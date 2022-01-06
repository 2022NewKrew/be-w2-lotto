package lotto.domain;

import java.util.List;

/**
 * Created by melodist
 * Date: 2022-01-06 006
 * Time: 오후 6:52
 */
public class LottoResult {
    private final List<String> message;
    private final float totalRateOfReturn;

    public LottoResult(List<String> message, float totalRateOfReturn) {
        this.message = message;
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public List<String> getMessage() {
        return message;
    }

    public float getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
