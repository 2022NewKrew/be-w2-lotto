package step2.dto;

import java.util.Map;

public class LottoResultDto {
    private final Map<String, Integer> lottoPrizeToResultMap;
    private final int purchaseAmount;

    public LottoResultDto(Map<String, Integer> lottoPrizeToResultMap, int purchaseAmount) {
        this.lottoPrizeToResultMap = lottoPrizeToResultMap;
        this.purchaseAmount = purchaseAmount;
    }

    public Map<String, Integer> getLottoPrizeToResultMap() {
        return lottoPrizeToResultMap;
    }
}
