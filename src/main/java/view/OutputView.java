package view;

import domain.Lotto;
import domain.LottoNumber;
import domain.Lottos;
import domain.Rank;
import java.util.Map;

public class OutputView {

    private static final String LOTTO_START = "[";
    private static final String LOTTO_SPLIT = ", ";
    private static final String LOTTO_END = "]\n";

    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---------\n";

    private static final String WINNING_STATISTICS_FORMAT = "%d개 일치 (%d원)- %d개\n";
    private static final String OUTPUT_PROFIT_RATE_FORMAT = "총 수익률은 %.2f%%입니다.";

    public static void outputLottos(Lottos lottos) {
        StringBuilder sb = new StringBuilder(String.format(LOTTO_PURCHASE_MESSAGE, lottos.size()));
        for (Lotto lotto : lottos.getLottos()) {
            sb.append(outputLotto(lotto));
        }
        System.out.println(sb);
    }

    private static String outputLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder(LOTTO_START);
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            sb.append(lottoNumber.getNumber()).append(LOTTO_SPLIT);
        }
        return sb.delete(sb.length() - LOTTO_SPLIT.length(), sb.length())
            .append(LOTTO_END).toString();
    }

    public static void outputWinning(Map<Integer, Integer> winningStatistics, float profitRate) {
        System.out.println(WINNING_STATISTICS_MESSAGE);

        final Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            int countOfMatch = rank.getCountOfMatch();
            int winningMoney = rank.getWinningMoney();
            int countOfWinningRank = winningStatistics.getOrDefault(countOfMatch, 0);
            System.out.printf(WINNING_STATISTICS_FORMAT, countOfMatch, winningMoney,
                countOfWinningRank);
        }

        System.out.printf(OUTPUT_PROFIT_RATE_FORMAT, profitRate);
    }
}
