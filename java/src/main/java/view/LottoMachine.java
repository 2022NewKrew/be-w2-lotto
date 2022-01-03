package view;

import domain.Lottery;
import domain.Lotto;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/*
 ** 실제 사용자와 커뮤니케이션하고 Lotto 클래스의 메서드를 호출하는 클래스
 */
public class LottoMachine {

    private Lotto lotto;
    private Scanner sc;
    private int money;
    private int totalPrize;

    public LottoMachine() {
        sc = new Scanner(System.in);
        lotto = new Lotto();
        money = 0;
        totalPrize = 0;
    }

    public void run() {
        List<Lottery> lotteries;
        List<Integer> winningNumber;
        int[] winCount;

        money = inputInt("구입금액을 입력해 주세요.");
        lotteries = buyLottery(money);
        printAllLottery(lotteries);
        winningNumber = inputIntegerList("지난 주 당첨 번호를 입력해 주세요.");
        Collections.sort(winningNumber);
        winCount = getAllLotteryResult(lotteries, winningNumber);
        printAllLotteryResult(winCount);
    }

    private List<Lottery> buyLottery(int money) {
        List<Lottery> lotteries = new ArrayList<>();
        int maximumLotteryCount = money / lotto.getPrice();
        System.out.printf("%d개를 구매했습니다.\n", maximumLotteryCount);

        while (maximumLotteryCount > 0) {
            lotteries.add(lotto.generateLottery());
            maximumLotteryCount--;
        }
        return lotteries;
    }

    //lottery 인스턴스로부터 일치하는 숫자개수를 받아와 일치하는 숫자개수 별로 카운트
    private int[] getAllLotteryResult(List<Lottery> lotteries,
                                      List<Integer> winningNumber) {
        int[] winCount = new int[7];
        for (var lottery : lotteries) {
            winCount[lottery.countMatchedNumber(winningNumber)]++;
        }
        return winCount;
    }

    private void printAllLottery(List<Lottery> lotteries) {
        for (var lottery : lotteries) {
            System.out.println(lottery.numbersToString());
        }
    }

    private void printAllLotteryResult(int[] winCount) {
        int minCount = 3;
        int maxCount = 6;
        int prize;

        totalPrize = 0;
        System.out.println("당첨 통계\n---------");
        for (int i = minCount; i <= maxCount; i++) {
            prize = lotto.getPrizeByMatchedNumberCount(i);
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, prize, winCount[i]);
            totalPrize += prize * winCount[i];
        }
        System.out.printf("총 수익률은 %d%% 입니다.\n", totalPrize * 100 / money);
    }

    private int inputInt(String msg) {
        System.out.println(msg);
        return Integer.parseInt(sc.nextLine());
    }

    private List<Integer> inputIntegerList(String msg) {
        System.out.println(msg);
        return Arrays.stream(sc.nextLine().split(","))
                .map(StringUtils::deleteWhitespace)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
