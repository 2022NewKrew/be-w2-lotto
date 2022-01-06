package lotto;

import java.math.BigDecimal;
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

    public static LottoController from(long money) {
        LottoMoney lottoMoney = new LottoMoney(money);
        Lottos lottos = Lottos.valueOf(lottoMoney.purchase());
        return new LottoController(lottos, lottoMoney);
    }

    public int purchase() {
        return lottoMoney.purchase();
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
