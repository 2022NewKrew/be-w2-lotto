package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by melodist
 * Date: 2022-01-06 006
 * Time: 오후 6:52
 */
public class LottoResult {
    private final List<String> message;
    private final BigDecimal totalRateOfReturn;

    public LottoResult(List<String> message, BigDecimal totalRateOfReturn) {
        this.message = message;
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public List<String> getMessage() {
        return message;
    }

    public BigDecimal getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
