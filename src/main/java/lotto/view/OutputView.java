package lotto.view;

import lotto.domain.Rank;
import lotto.dto.InfoDto;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.ResultDto;

public class OutputView {

    final static String LOTTOS_INFO_MESSAGE = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    final static String RESULT_INTRO_MESSAGE = "\n당첨 통계\n--------";
    final static String WINNING_STATISTICS_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    final static String WINNING_STATISTICS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    final static String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f%%입니다.";

    public static void printLottoGameInfo(InfoDto infoDto) {
        printLottos(infoDto.getLottosDto());
        printResult(infoDto.getResultDto());
    }

    public static void printLottos(LottosDto lottosDto) {
        System.out.println(String.format(LOTTOS_INFO_MESSAGE, lottosDto.getCustomLottoCount(), lottosDto.getAutoLottoCount()));
        for (LottoDto lottoDto : lottosDto.getLottoDtos()) {
            System.out.println(lottoDto.getLottoNumber());
        }
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
