package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PurchasedLotto {
    private final List<Lotto> lottoList;

    public PurchasedLotto(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getPurchasedLottos() {
        return Collections.unmodifiableList(lottoList);
    }

    public List<LottoResult> getPurchasedResult(WinningLotto winningLotto) {
        return lottoList.stream()
                .map(lotto -> LottoResult.getResult(lotto.getNumMatchingDigits(winningLotto), lotto.isContainBonus(winningLotto)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public long getNumPurchasedLotto() {
        return lottoList.size();
    }
}
