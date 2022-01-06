package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinningResult {
    public static final int ZERO = 0;

    private final List<LottoResult> lottoResultList;

    public WinningResult(List<LottoResult> lottoResultList) {
        this.lottoResultList = lottoResultList;
    }

    public List<LottoResult> getWinningResult() {
        return Collections.unmodifiableList(lottoResultList);
    }

    public int getCountOf(LottoResult lottoResult) {
        if (lottoResultList.isEmpty()) {
            return ZERO;
        }
        return Collections.frequency(lottoResultList, lottoResult);
    }

    public static WinningResult winningResultOf(WinningLotto winningLotto, PurchasedLottos purchasedLottos) {
        return new WinningResult(purchasedLottos.getLottoList()
                .stream()
                .map(winningLotto::getPurchasedResult)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList()));
    }

    public double getYield(long purchaseAmount) {
        long totalReward = lottoResultList.stream()
                .mapToLong(LottoResult::getReward).sum();
        return (double) (totalReward - purchaseAmount) / purchaseAmount * 100;
    }
}
