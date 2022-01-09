package domain;

import java.util.Map;

public class LottoYield {

    public double getProfitRate(LottoRankMatch lottoRankMatch, int purchasedAmount) {
        double profit = 0.0;
        for (Map.Entry<LottoRank, Integer> resultIndex : lottoRankMatch.getLottoResult().entrySet()) {
            profit += (resultIndex.getKey().getMoney() * resultIndex.getValue());
        }
        return (profit - purchasedAmount) / purchasedAmount * 100;
    }

}
