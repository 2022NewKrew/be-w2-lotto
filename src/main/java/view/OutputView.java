package view;

import domain.Lotto;
import domain.LottoProfitRate;
import domain.LottoRank;
import domain.LottoRepository;

import java.util.Map;

public class OutputView {
    private static final String STATISTICS = "당첨 통계";
    private static final String DASH = "-----------";

    public static void printAutoLottos(LottoRepository autuLottos) {
        for (Lotto autoLotto : autuLottos.getLottos()) {
            System.out.println(autoLotto.getLotto());
        }
    }

    public static void printProfit(Map<LottoRank, Integer> lottoRankResult, int purchasedAmount) {
        System.out.println();
        System.out.println(STATISTICS);
        System.out.println(DASH);
        LottoProfitRate.createProfitRate(lottoRankResult, purchasedAmount);
    }
}
