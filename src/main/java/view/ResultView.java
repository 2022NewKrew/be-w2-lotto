package view;

import domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    public static void printPurchaseResult(List<Lotto> lottos, int manualLottoCount) {
        printLottoCount(lottos, manualLottoCount);
        printLottos(lottos);
    }

    public static void printResult(Results results) {
        printStats(results);
    }

    public static void printROI(Results results, int money) {
        long earnedMoney = getEarnedMoney(results);
        int earnedRate = (int) Math.floor((earnedMoney - money) / ((double) money) * 100);

        System.out.println("총 수익률은 " + earnedRate + "% 입니다.");
    }

    private static void printLottoCount(List<Lotto> lottos, int manualLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "개, 자동으로 " + (lottos.size() - manualLottoCount) + "개를 구매했습니다.");
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(ResultView::lottoToString)
                .forEach(System.out::println);
    }

    private static String lottoToString(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toUnmodifiableList())
                .toString();
    }

    private static void printStats(Results results) {
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Result> copiedResults = new ArrayList<>(results.getResults());
        Collections.reverse(copiedResults);
        copiedResults.forEach(copiedResult -> System.out.println(resultToString(copiedResult)));
    }

    private static String resultToString(Result result) {
        Rank rank = result.getRank();
        int count = result.getCount();

        String resultString = "" + rank.getCountOfMatch() + "개 일치";
        if (rank == Rank.SECOND) {
            resultString += ",보너스 볼 일치";
        }
        resultString += "(" + rank.getWinningMoney() + "원) - " + count + "개";
        return resultString;
    }


    private static long getEarnedMoney(Results results) {
        long sum = 0L;
        for (Result result : results.getResults()) {
            sum += result.getCount() * (long) result.getRank().getWinningMoney();
        }
        return sum;
    }
}
