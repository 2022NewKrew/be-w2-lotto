package step2.dto;

import java.util.Map;

public class LottoResultDto {
    private final Map<Integer, Integer> lottoPrizeToResultMap;
    private final int purchaseAmount;

    public LottoResultDto(Map<Integer, Integer> lottoPrizeToResultMap, int purchaseAmount) {
        this.lottoPrizeToResultMap = lottoPrizeToResultMap;
        this.purchaseAmount = purchaseAmount;
    }

    public Map<Integer, Integer> getLottoPrizeToResultMap() {
        return lottoPrizeToResultMap;
    }
}
