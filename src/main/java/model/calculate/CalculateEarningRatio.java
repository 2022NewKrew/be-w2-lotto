package model.calculate;

import constants.LottoRankInfoList;
import constants.LottoRule;
import parameters.LottoResult;

public class CalculateEarningRatio {
    public CalculateEarningRatio() { }

    public long calculateEarningRatio(LottoResult lottoResult, int amountOfLotto){
        long earned = LottoRankInfoList.getInstance()
                .getRankInfoStream()
                .mapToLong((rankInfo -> lottoResult.getResult(rankInfo).getEarned()))
                .sum();

        double ratio = (float)(earned - (1.0 * amountOfLotto * LottoRule.PRICE_PER_LOTTO))
                / (amountOfLotto * LottoRule.PRICE_PER_LOTTO);

        return Math.round(ratio * 100);
    }
}
