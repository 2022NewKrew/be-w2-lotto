package model.calculate;

import constants.LottoRule;
import constants.RankInfo;
import parameters.LottoResult;

public class CalculateEarningRatio {
    private CalculateEarningRatio() {
    }

    public static double calculateEarningRatio(LottoResult lottoResult, int amountOfLotto) {
        long earned = RankInfo.valuesStream()
                .mapToLong((rankInfo -> rankInfo.getEarned(lottoResult.getResult(rankInfo))))
                .sum();

        return (float) (earned - (1.0 * amountOfLotto * LottoRule.PRICE_PER_LOTTO))
                / (amountOfLotto * LottoRule.PRICE_PER_LOTTO);
    }
}
