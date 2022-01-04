package view;

import domain.Lottos;
import domain.WinningStatistics;

public class ResultView {
    private static final String MESSAGE_PURCHASING_COUNT = "개를 구입하셨습니다.";
    private static final String MESSAGE_WINNING_RESULT = String.format("%s%s%s", "당첨 통계", System.lineSeparator(), "---------");
    private static final String MESSAGE_RANK_COUNT = "%s (%d원)- %d개";
    private static final String MESSAGE_TOTAL_PROFITS = "총 수익률은 %d%%입니다.";
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
                .forEach(rank -> System.out.println(String.format(MESSAGE_RANK_COUNT, rank.message(), rank.amount(), winningStatistics.statistics().get(rank))));
        System.out.println(String.format(MESSAGE_TOTAL_PROFITS, winningStatistics.profits()));
    }
}