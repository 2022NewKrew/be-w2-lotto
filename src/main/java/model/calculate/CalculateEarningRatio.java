package model.calculate;

import constants.LottoRule;
import parameters.LottoResult;

public class CalculateEarningRatio {
    public CalculateEarningRatio() { }

    public long calculateEarningRatio(LottoResult lottoResult, int amountOfLotto){
        long earned = 0;
        for(int rank = LottoRule.FAIL + 1; rank < LottoRule.FIRST + 1; rank++){
            earned += (lottoResult.getResult(rank).getEarned());
        }
        double ratio = (float)(earned - (1.0 * amountOfLotto * LottoRule.PRICE_PER_LOTTO))
                / (amountOfLotto * LottoRule.PRICE_PER_LOTTO);

        return Math.round(ratio * 100);
    }
}
