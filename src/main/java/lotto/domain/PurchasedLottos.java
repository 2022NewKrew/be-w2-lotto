package lotto.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PurchasedLottos {
    private final List<Lotto> lottoList;

    public PurchasedLottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<LottoResult> getPurchasedResult(WinningLotto winningLotto) {
        return lottoList.stream()
                .map(lotto -> LottoResult.getResult(lotto.getNumOfMatchingNumbersWith(winningLotto.getLotto()), lotto.containsLottoNumber(winningLotto.getBonusNumber())))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
