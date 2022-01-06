package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningResult {
    public static final int ZERO = 0;
  
    private final List<LottoResult> purchasedResult;

    public WinningResult(List<LottoResult> purchasedResult) {
        this.purchasedResult = purchasedResult;
    }

    public List<LottoResult> getWinningResult() {
        return Collections.unmodifiableList(purchasedResult);
    }

    public int getCountOf(LottoResult lottoResult) {
        if (purchasedResult.isEmpty()) {
            return ZERO;
        }
    }
}
