package view;

import domain.Lottos;
import domain.WinningStatistics;

public class ResultView {
    private static final String MESSAGE_PURCHASING_COUNT = "개를 구입하셨습니다.";
    private static final String MESSAGE_WINNING_RESULT = String.format("%s%s%s", "당첨 통계", System.lineSeparator(), "---------");
    private static final String MESSAGE_OPEN_PARENTHESES = " (";
    private static final String MESSAGE_WON_CLOSE_PARENTHESES = "원)- ";
    private static final String MESSAGE_COUNT = "개";
    private static final String MESSAGE_TOTAL_PROFITS = "총 수익률은 ";
    private static final String MESSAGE_IS = "%입니다.";

    private ResultView() {}

    public static void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.lottos().size() + MESSAGE_PURCHASING_COUNT);
        lottos.lottos()
                .forEach(lotto -> System.out.println(lotto.lottoNumbers()));
        System.out.println();
    }

    public static void printResult(WinningStatistics winningStatistics) {
        System.out.println();
        System.out.println(MESSAGE_WINNING_RESULT);
        winningStatistics.statistics()
                .keySet()
                .stream()
                .filter(rank -> rank.hit() > 0)
                .sorted()
                .forEach(rank -> System.out.println(String.format("%s%s%s%s%s%s", rank.message(), MESSAGE_OPEN_PARENTHESES, rank.amount(), MESSAGE_WON_CLOSE_PARENTHESES, winningStatistics.statistics().get(rank), MESSAGE_COUNT)));
        System.out.println(MESSAGE_TOTAL_PROFITS + winningStatistics.profits() + MESSAGE_IS);
    }
}