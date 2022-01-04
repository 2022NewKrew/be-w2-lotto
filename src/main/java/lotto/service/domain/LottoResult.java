package lotto.service.domain;

import java.util.Map;

public class LottoResult {
    private Map<LottoPrizeDetails, Integer> wholeResult ;
    private long wholePrizeMoney;

    public LottoResult(Map<LottoPrizeDetails, Integer> wholeResult, long wholePrizeMoney) {
        this.wholeResult = wholeResult;
        this.wholePrizeMoney = wholePrizeMoney;
    }

    public Map<LottoPrizeDetails, Integer> getWholeResult() {
        return wholeResult;
    }

    public long getWholePrizeMoney() {
        return wholePrizeMoney;
    }
}
