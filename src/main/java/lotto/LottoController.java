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

    public static LottoController valueOf(long money, List<List<Integer>> selfLottoNumbers) {
        LottoMoney lottoMoney = new LottoMoney(money);
        Lottos lottos = Lottos.from(lottoMoney.purchase(), selfLottoNumbers);
        return new LottoController(lottos, lottoMoney);
    }

    public int purchase() {
        return lottoMoney.purchase();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public LottoResult result(List<Integer> winningNumbers, int bonusBallNumber) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBallNumber);
        return lottos.matchCounts(winningLotto);
    }

    public BigDecimal profit(BigDecimal totalReward) {
        return lottoMoney.profit(totalReward);
    }
}
