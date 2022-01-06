package lotto.domain;

import java.util.List;

public class LottoResult {
    private final List<String> message;
    private final double totalRateOfReturn;

    public LottoResult(List<String> message, double totalRateOfReturn) {
        this.message = message;
        this.totalRateOfReturn = totalRateOfReturn;
    }
}
