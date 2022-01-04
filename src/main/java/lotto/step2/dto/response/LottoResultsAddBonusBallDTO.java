package lotto.step2.dto.response;

import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoResult;

import java.util.EnumSet;
import java.util.Map;

public class LottoResultsAddBonusBallDTO extends LottoResultsDTO {

    private LottoResultsAddBonusBallDTO(Map<LottoResult, Integer> numOfWinsMap, double yield) {
        super(numOfWinsMap, yield);
    }

    public static LottoResultsAddBonusBallDTO of(Lotto lotto) {
        final double yield = calcYield(lotto);
        return new LottoResultsAddBonusBallDTO(lotto.getLottoResults(), yield);
    }

    @Override
    public EnumSet<LottoResult> getLottoResults() {
        return LottoResult.getEnumSetFirstToFourthPlaceAddBonusPlace();
    }
}
