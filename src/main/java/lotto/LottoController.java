package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoController {

    private final Lottos lottos;
    private final LottoMoney lottoMoney;

    private LottoController(Lottos lottos, LottoMoney lottoMoney) {
        this.lottos = lottos;
        this.lottoMoney = lottoMoney;
    }

    public static LottoController of(long money, List<List<Integer>> manualLottoNumbers) {
        LottoMoney lottoMoney = new LottoMoney(money);
        Lottos lottos = Lottos.of(lottoMoney.purchase(), manualLottoNumbers);
        return new LottoController(lottos, lottoMoney);
    }

    public static LottoController of(long money) {
        return of(money, new ArrayList<>());
    }

    public int manualPurchase() {
        return lottos.getManualPurchase();
    }

    public int autoPurchase() {
        return lottos.getAutoPurchase();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public LottoResult result(List<Integer> winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        return lottos.matchCounts(winningLotto);
    }

    public BigDecimal profit(BigDecimal totalReward) {
        return lottoMoney.profit(totalReward);
    }
}
