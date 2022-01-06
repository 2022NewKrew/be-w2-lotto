package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.vo.LottoMoneyVo;
import lotto.vo.LottosVo;

public class LottoController {

    private final LottosVo lottosVo;
    private final LottoMoneyVo lottoMoneyVo;

    private LottoController(LottosVo lottosVo, LottoMoneyVo lottoMoneyVo) {
        this.lottosVo = lottosVo;
        this.lottoMoneyVo = lottoMoneyVo;
    }

    public static LottoController of(long money, List<List<Integer>> manualLottoNumbers) {
        LottoMoneyVo lottoMoneyVo = new LottoMoneyVo(new LottoMoney(money));
        LottosVo lottosVo = new LottosVo(Lottos.of(lottoMoneyVo.purchase(), manualLottoNumbers));
        return new LottoController(lottosVo, lottoMoneyVo);
    }

    public static LottoController of(long money) {
        return of(money, new ArrayList<>());
    }

    public int manualPurchase() {
        return lottosVo.getManualPurchase();
    }

    public int autoPurchase() {
        return lottosVo.getAutoPurchase();
    }

    public LottosVo getLottos() {
        return lottosVo;
    }

    public LottoResult result(List<Integer> winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        return lottosVo.matchCounts(winningLotto);
    }

    public BigDecimal profit(BigDecimal totalReward) {
        return lottoMoneyVo.profit(totalReward);
    }
}
