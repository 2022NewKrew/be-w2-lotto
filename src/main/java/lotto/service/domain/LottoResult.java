package lotto.service.domain;

import java.util.Map;

public class LottoResult {
    private Map<LottoPrizeDetails, Integer> wholeResult ;
    private double yield;

    public LottoResult(Map<LottoPrizeDetails, Integer> wholeResult, double yield) {
        this.wholeResult = wholeResult;
        this.yield = yield;
    }

    public Map<LottoPrizeDetails, Integer> getWholeResult() {
        return wholeResult;
    }

    public double getYield() {
        return yield;
    }
}
