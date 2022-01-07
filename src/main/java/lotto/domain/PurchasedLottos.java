package lotto.domain;

import java.util.Collections;
import java.util.List;

public class PurchasedLottos {

    private final List<Lotto> lottoList;

    public PurchasedLottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }
}
