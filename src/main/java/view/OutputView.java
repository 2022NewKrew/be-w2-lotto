package view;

import domain.Lotto;
import domain.LottoNumber;
import domain.Lottos;
import domain.Rank;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LOTTO_START = "[";
    private static final String LOTTO_SPLIT = ", ";
    private static final String LOTTO_END = "]\n";

    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_INFO_MESSAGE = "\n당첨 통계\n---------\n";

    private static final String WINNING_STATISTICS_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String WINNING_STATISTICS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static final String OUTPUT_PROFIT_RATE_MESSAGE = "총 수익률은 %.2f%%입니다.";

    public static void outputLottos(Lottos lottos) {
        StringBuilder sb = new StringBuilder(String.format(LOTTO_PURCHASE_MESSAGE, lottos.size()));
        for (Lotto lotto : lottos.getLottos()) {
            sb.append(outputLotto(lotto));
        }
        System.out.println(sb);
    }

    private static String outputLotto(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(Collectors.joining(LOTTO_SPLIT, LOTTO_START, LOTTO_END));
    }

    public static void outputWinning(Map<Rank, Integer> winningStatistics, float profitRate) {
        System.out.println(WINNING_STATISTICS_INFO_MESSAGE);

        final Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            int countOfWinningRank = winningStatistics.getOrDefault(rank, 0);
            System.out.print(outputRankInfo(rank, countOfWinningRank));
        }

        System.out.printf(OUTPUT_PROFIT_RATE_MESSAGE, profitRate);
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
