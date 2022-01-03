package view;

import domain.Lotto;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int FOURTH_PRICE = 5000;
    private static final int THIRD_PRICE = 50000;
    private static final int SECOND_PRICE = 1500000;
    private static final int FIRST_PRICE = 2000000000;
    private static final int FOURTH_MATCH_NUM = 3;
    private static final int THIRD_MATCH_NUM = 4;
    private static final int SECOND_MATCH_NUM = 5;
    private static final int FIRST_MATCH_NUM = 6;

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

    private static String getFormattedPrice(Integer count) {
        if (count == 3) return "(" + FOURTH_PRICE + "원)";
        if (count == 4) return "(" + THIRD_PRICE + "원)";
        if (count == 5) return "(" + SECOND_PRICE + "원)";
        return "(" + FIRST_PRICE + "원)";
    }


    private static void printROI(Map<Integer, Integer> winningResult, int money) {
        int earnedMoney = getEarnedMoney(winningResult);
        System.out.println("총 수익률은 " +  (int)Math.floor(earnedMoney/(money*1.0) * 100) + "% 입니다.");
    }

    private static int getEarnedMoney(Map<Integer, Integer> winningResult) {
        return winningResult.entrySet()
                .stream()
                .map(entry -> getPrice(entry.getKey(), entry.getValue()))
                .reduce(0, Integer::sum);
    }

    private static int getPrice(int matchNum, int cnt) {
        if(cnt<1) return 0;

        int sum = 0;
        switch (matchNum) {
            case FOURTH_MATCH_NUM:
                sum += FOURTH_PRICE * cnt;
                break;
            case THIRD_MATCH_NUM:
                sum += THIRD_PRICE * cnt;
            case SECOND_MATCH_NUM:
                sum += SECOND_PRICE * cnt;
            case FIRST_MATCH_NUM:
                sum += FIRST_PRICE * cnt;
        }
        return sum;
    }
}
