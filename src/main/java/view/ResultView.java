package view;

import domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final List<Long> PRIZES = Arrays.asList(0L, 0L, 0L, 5000L, 50_000L, 1_500_000L, 2_000_000_000L);

    public static void printPurchaseResult(List<Lotto> lottos) {
        printLottoCount(lottos);
        printLottos(lottos);
    }

    public static void printWinningResult(Map<Integer, Integer> winningResult, int money) {
        printWinningStats(winningResult);
        printROI(winningResult,money);
    }

    private static void printLottoCount(List<Lotto> lottos) {
        System.out.printf("%d개 구매했습니다.\n", lottos.size());
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    private static void printWinningStats(Map<Integer, Integer> winningResult) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");
        winningResult.entrySet()
                .forEach(entry -> System.out.println(getFormattedResult(entry)));
    }


    private static String getFormattedResult(Map.Entry<Integer, Integer> entry) {
        return entry.getKey() + "개 일치 " + getFormattedPrice(entry.getKey()) + "- " + entry.getValue() + "개";
    }

    private static String getFormattedPrice(int rank) {
        return "(" + PRIZES.get(rank) + "원)";
    }


    private static void printROI(Map<Integer, Integer> winningResult, int money) {
        long earnedMoney = getEarnedMoney(winningResult);
        System.out.println("총 수익률은 " +  (int)Math.floor(earnedMoney/(money*1.0) * 100) + "% 입니다.");
    }

    private static long getEarnedMoney(Map<Integer, Integer> winningResult) {
        return winningResult.entrySet()
                .stream()
                .map(entry -> getPrice(entry.getKey(), entry.getValue()))
                .reduce(0L, Long::sum);
    }

    private static long getPrice(int rank, int cnt) {
        if(cnt<1) return 0;

        return PRIZES.get(rank)*cnt;
    }
}
