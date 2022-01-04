package view;

import domain.Lotto;
import domain.Rank;
import domain.Result;

import java.util.*;

public class ResultView {
    private static final List<Long> PRIZES = Arrays.asList(0L, 0L, 0L, 5000L, 50_000L, 1_500_000L, 2_000_000_000L);

    public static void printPurchaseResult(List<Lotto> lottos) {
        printLottoCount(lottos);
        printLottos(lottos);
    }

    public static void printWinningResult(List<Result> results, int money) {
        printWinningStats(results);
        printROI(results,money);
    }

    private static void printLottoCount(List<Lotto> lottos) {
        System.out.printf("%d개 구매했습니다.\n", lottos.size());
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    private static void printWinningStats(List<Result> results) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Result> copiedResults = new ArrayList<>(results);
        Collections.reverse(copiedResults);
        copiedResults.forEach(copiedResult -> System.out.println(copiedResult.toString()));
    }

    private static void printROI(List<Result> results, int money) {
        long earnedMoney = getEarnedMoney(results);
        int earnedRate = (int)Math.floor(earnedMoney/(money*1.0) * 100);

        System.out.println("총 수익률은 " + earnedRate + "% 입니다.");
    }

    private static long getEarnedMoney(List<Result> results) {
        long sum = 0L;
        for(Result result : results){
            sum+= result.getCount() *  (long)result.getRank().getWinningMoney();
        }
        return sum;
    }
}
