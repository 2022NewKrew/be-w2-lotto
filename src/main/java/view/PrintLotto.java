package view;

import lotto.Lotto;
import lotto.LottoMachine;
import lotto.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrintLotto {

    public static void start() {
        int money = getMoney();
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.buyLotto(money);
        printLottos(lottoMachine.getLottos());
        WinningLotto winLotto = getWinLotto();
        List<Integer> matchCounts = lottoMachine.countLottoMatch(winLotto);
        printLottoResult(money, matchCounts);
    }

    private static int getMoney() {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        System.out.println("구입금액을 입력해 주세요.");
        return in.nextInt();
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto: lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    private static WinningLotto getWinLotto() {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLotto(splitNumbers(in.next()));
    }

    private static List<Integer> splitNumbers(String numStr) {
        final List<String> inputs = new ArrayList<>(Arrays.asList(numStr.split(",")));
        return inputs.stream().map(x -> Integer.parseInt(x.trim())).collect(Collectors.toList());
    }

    private static void printLottoResult(int money, List<Integer> matchCounts) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + matchCounts.get(3) + "개");
        System.out.println("4개 일치 (50000원)- " + matchCounts.get(4) + "개");
        System.out.println("5개 일치 (1500000원)- " + matchCounts.get(5) + "개");
        System.out.println("6개 일치 (2000000000원)- " + matchCounts.get(6) + "개");
        System.out.println("총 수익률은 " + calcProfit(matchCounts) / money + "%입니다.");
    }

    private static int calcProfit(List<Integer> matchCounts) {
        return matchCounts.get(3) * 5000
                + matchCounts.get(4) * 50000
                + matchCounts.get(5) * 1500000
                + matchCounts.get(6) * 200000000;
    }
}
