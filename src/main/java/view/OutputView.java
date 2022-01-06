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
    private static final String SECOND_PRICE_ADDITION_STRING = ", 보너스 볼 일치";
    private static final String TOTAL_PROFIT_RATE = "총 수익률은 %.2f 입니다.";

    public static void printAutoLottos(LottoRepository autoLottos) {
        for (Lotto autoLotto : autoLottos.getLottos()) {
            System.out.println(autoLotto.getLotto());
        }
    }

    public static void printProfit(LottoRankMatch lottoRankMatch, double profitRate) {
        System.out.println();
        System.out.println(STATISTICS);
        System.out.println(DASH);
        for (Map.Entry<LottoRank, Integer> resultIndex : lottoRankMatch.getLottoResult().entrySet()) {
            String haveBonusBall = (resultIndex.getKey().getMoney() == 30_000_000) ? SECOND_PRICE_ADDITION_STRING : " ";
            System.out.println(String.format(NUM_OF_MATCHED, resultIndex.getKey().getCountOfMatch(), haveBonusBall, resultIndex.getKey().getMoney(), resultIndex.getValue()));
        }
        System.out.println(String.format(TOTAL_PROFIT_RATE, profitRate));
    }
}