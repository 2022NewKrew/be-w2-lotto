package view;

import lotto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrintLotto {

    public static void start() {
        int money = getMoney();
        int manualCount = getManualCount();
        List<Lotto> manualLottos = getManualLottos(manualCount);
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.addManualLottos(manualLottos);
        lottoMachine.buyLotto(money - manualCount*1000);
        printLottos(lottoMachine.getManualLottos(), lottoMachine.getAutomaticLottos());
        WinningLotto winLotto = getWinLotto();
        RankCount rankCount = lottoMachine.getRankCount(winLotto);
        printLottoResult(money, rankCount);
    }

    private static int getMoney() {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        System.out.println("구입금액을 입력해 주세요.");
        return in.nextInt();
    }

    private static int getManualCount() {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return in.nextInt();
    }

    private static List<Lotto> getManualLottos(int manualCount) {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottos.add(new Lotto(splitNumbers(in.next())));
        }
        return manualLottos;
    }

    private static void printLottos(List<Lotto> manualLottos, List<Lotto> automaticLottos) {
        System.out.println("수동으로 " + manualLottos.size() + "장, 자동으로 " + automaticLottos.size() + "장을 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(automaticLottos);
        for(Lotto lotto: lottos) {
            System.out.println(lotto.getLottoNumbers().stream().map(x -> x.ordinal() + 1).collect(Collectors.toList()));
        }
    }

    private static WinningLotto getWinLotto() {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<LottoBall> winningNumbers = splitNumbers(in.next());
        System.out.println("보너스 볼을 입력해 주세요.");
        LottoBall bonusBall = LottoBall.values()[in.nextInt()-1];
        return new WinningLotto(winningNumbers, bonusBall);
    }

    private static List<LottoBall> splitNumbers(String numStr) {
        final List<String> inputs = new ArrayList<>(Arrays.asList(numStr.split(",")));
        return inputs.stream().map(x -> LottoBall.values()[Integer.parseInt(x.trim())-1]).collect(Collectors.toList());
    }

    private static void printLottoResult(int money, RankCount rankCount) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + rankCount.getFifthCount() + "개");
        System.out.println("4개 일치 (50000원)- " + rankCount.getFourthCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + rankCount.getThirdCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + rankCount.getSecondCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + rankCount.getFirstCount() + "개");
        System.out.println("총 수익률은 " + (calcProfit(rankCount) - money) * 100 / money + "%입니다.");
    }

    private static long calcProfit(RankCount rankCount) {
        return rankCount.getFifthCount() * Rank.FIFTH.getWinningMoney()
                + rankCount.getFourthCount() * Rank.FOURTH.getWinningMoney()
                + rankCount.getThirdCount() * Rank.THIRD.getWinningMoney()
                + rankCount.getSecondCount() * Rank.SECOND.getWinningMoney()
                + rankCount.getFirstCount() * Rank.FIRST.getWinningMoney();
    }
}
