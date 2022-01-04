package view;

import domain.Lotto;
import domain.Result;
import domain.Results;

import java.util.*;

public class ResultView {

    public static void printPurchaseResult(List<Lotto> lottos) {
        printLottoCount(lottos);
        printLottos(lottos);
    }

    public static void printResult(Results results) {
        printStats(results);
    }

    public static void printROI(Results results, int money) {
        long earnedMoney = getEarnedMoney(results);
        int earnedRate = (int) Math.floor(earnedMoney / ((double) money) * 100);

        System.out.println("총 수익률은 " + earnedRate + "% 입니다.");
    }

    private static void printLottoCount(List<Lotto> lottos) {
        System.out.printf("%d개 구매했습니다.\n", lottos.size());
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    private static void printStats(Results results) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Result> copiedResults = new ArrayList<>(results.getResults());
        Collections.reverse(copiedResults);
        copiedResults.forEach(copiedResult -> System.out.println(copiedResult.toString()));
    }


    private static long getEarnedMoney(Results results) {
        long sum = 0L;
        for (Result result : results.getResults()) {
            sum += result.getCount() * (long) result.getRank().getWinningMoney();
        }
        return sum;
    }
}
