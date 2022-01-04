package model.calculate;

import constants.LottoRule;
import constants.RankInfo;
import parameters.LottoResult;

public class CalculateEarningRatio {
    public CalculateEarningRatio() { }

    public static double calculateEarningRatio(LottoResult lottoResult, int amountOfLotto){
        long earned = RankInfo.valuesStream()
                .mapToLong((rankInfo -> rankInfo.getEarned(lottoResult.getResult(rankInfo))))
                .sum();

        double ratio = (float)(earned - (1.0 * amountOfLotto * LottoRule.PRICE_PER_LOTTO))
                / (amountOfLotto * LottoRule.PRICE_PER_LOTTO);

        return Math.round(ratio * 10000) / 100.0;
    }
}
