package view;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoRankMatch;
import domain.LottoRepository;

import java.util.Map;

public class OutputView {
    private static final String STATISTICS = "당첨 통계";
    private static final String DASH = "-----------";
    private static final String NUM_OF_MATCHED = "%d개 일치%s(%d원)- %d개";
    public static final String SECOND_PRICE_ADDITION_STRING = ", 보너스 볼 일치";

    public static void printAutoLottos(LottoRepository autuLottos) {
        for (Lotto autoLotto : autuLottos.getLottos()) {
            System.out.println(autoLotto.getLotto());
        }
    }

    public static void printProfit(LottoRankMatch lottoRankMatch, double profitRate) {
        System.out.println();
        System.out.println(STATISTICS);
        System.out.println(DASH);
        for (Map.Entry<LottoRank, Integer> resultIndex : lottoRankMatch.getLottoResult().entrySet()) {

            System.out.println(resultIndex.getKey().getCountOfMatch() + resultIndex.getValue() + "개");
        }
        System.out.println(String.format("%2f", profitRate));
    }
}