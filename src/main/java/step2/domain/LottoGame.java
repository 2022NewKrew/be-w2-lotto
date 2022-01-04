package step2.domain;

import step2.domain.model.BonusNumber;
import step2.domain.model.Lottos;
import step2.domain.model.Result;
import step2.view.LottoView;

public class LottoGame {
    private final LottoView lottoView;

    public LottoGame() {
        Lottos lottos = new Lottos(LottoView.askMoneyForBuyLotto());
        this.lottoView = new LottoView(lottos);
    }

    public void start() {
        this.lottoView.printLottos();

        Result result = this.lottoView.askResult();
        BonusNumber bonusNumber = this.lottoView.askBonusNumber(result);

        this.lottoView.printMatches(result, bonusNumber);
        this.lottoView.printEarningRate();
    }
}
