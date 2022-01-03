package step1.domain;

import step1.domain.model.Lottos;
import step1.view.LottoView;

public class LottoGame {
    private final LottoView lottoView;

    public LottoGame() {
        Lottos lottos = new Lottos(LottoView.askMoneyForBuyLotto());
        this.lottoView = new LottoView(lottos);
    }

    public void start() {
        this.lottoView.printLottos();
        this.lottoView.printMatches(this.lottoView.askResult());
        this.lottoView.printEarningRate();
    }
}
