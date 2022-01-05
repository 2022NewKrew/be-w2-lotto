package view;

import domain.Lotto;
import domain.LottoProfitRate;
import domain.LottoRank;
import domain.LottoRepository;

import java.util.Map;

public class OutputView {

    public static void printAutoLottos(LottoRepository autuLottos) {
        for (Lotto autoLotto : autuLottos.getLottos()) {
            System.out.println(autoLotto.getLotto());
        }
    }

    public static void printProfit(Map<LottoRank, Integer> lottoRankResult, int purchasedAmount) {
        LottoProfitRate.createProfitRate(lottoRankResult, purchasedAmount);
    }
}
