package step3.domain;

import step3.domain.model.BonusNumber;
import step3.domain.model.Lotto;
import step3.domain.model.Lottos;
import step3.domain.model.Result;
import step3.view.LottoView;

import java.util.List;

public class LottoGame {
    private LottoView lottoView;

    public void start() {
        int manualLottosQuantity = makeLottoView();
        lottoView.printLottos(manualLottosQuantity);

        Result result = lottoView.askResult();
        BonusNumber bonusNumber = lottoView.askBonusNumber(result);

        lottoView.printMatches(result, bonusNumber);
        lottoView.printEarningRate();
    }

    private int makeLottoView() {
        int lottosQuantity = LottoView.askMoneyForBuyLottos();
        int manualLottosQuantity = LottoView.askManualLottosQuantity(lottosQuantity);
        int autoLottosQuantity = lottosQuantity - manualLottosQuantity;

        List<Lotto> manualLottos = LottoView.askManualLottos(manualLottosQuantity);
        Lottos lottos = new Lottos(manualLottos, autoLottosQuantity);
        this.lottoView = new LottoView(lottos);

        return manualLottosQuantity;
    }
}
