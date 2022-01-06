package lotto.vo;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottosVo {

    private final Lottos lottos;

    public LottosVo(Lottos lottos) {
        this.lottos = lottos;
    }

    public int getManualPurchase() {
        return lottos.getManualPurchase();
    }

    public int getAutoPurchase() {
        return lottos.getAutoPurchase();
    }

    public LottoResult matchCounts(WinningLotto winningLotto) {
        return lottos.matchCounts(winningLotto);
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
