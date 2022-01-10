package lotto.view;

import lotto.domain.Rank;
import lotto.dto.InfoDto;
import lotto.dto.ResultDto;

public class OutputView {

    final static String RESULT_INTRO_MESSAGE = "\n당첨 통계\n--------";
    final static String WINNING_STATISTICS_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    final static String WINNING_STATISTICS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    final static String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f%%입니다.";

    public static void printLottoInfo(InfoDto infoDto) {
        printResult(infoDto.getResultDto());
    }

    public static void printResult(ResultDto resultDto) {
        final Rank[] ranks = Rank.values();
        System.out.println(RESULT_INTRO_MESSAGE);
        for (Rank rank : ranks) {
            int countOfWinningRank = resultDto.getResult().getOrDefault(rank, 0);
            System.out.print(outputRankInfo(rank, countOfWinningRank));
        }
        System.out.println(String.format(PROFIT_RATE_MESSAGE, resultDto.getYield()));
    }

    private static String outputRankInfo(Rank rank, int countOfWinningRank) {
        int countOfMatch = rank.getCountOfMatch();
        int winningMoney = rank.getWinningMoney();

        if (rank == Rank.SECOND) {
            return String.format(WINNING_STATISTICS_BONUS_MESSAGE, countOfMatch, winningMoney,
                countOfWinningRank);
        }
        return String.format(WINNING_STATISTICS_MESSAGE, countOfMatch, winningMoney,
            countOfWinningRank);
    }
}
