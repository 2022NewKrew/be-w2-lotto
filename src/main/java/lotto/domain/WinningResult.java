package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return Collections.frequency(purchasedResult, lottoResult);
    }

    public static WinningResult winningResultOf(WinningLotto winningLotto, PurchasedLottos purchasedLottos) {
        return new WinningResult(purchasedLottos.getLottoList()
                .stream()
                .map(winningLotto::getPurchasedResult)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList()));
    }
}
