package step3.domain;

import step3.domain.model.BonusNumber;
import step3.domain.model.Lotto;
import step3.domain.model.Lottos;
import step3.domain.model.Result;
import step3.view.LottoView;

import java.util.List;

public class LottoGame {
    private int manualLottosQuantity;
    private int autoLottosQuantity;
    private LottoView lottoView;

    public void start() {
        insertQuantities();
        initLottoView();
        printInfosWithResult();
    }

    private void insertQuantities() {
        int lottosQuantity = LottoView.askMoneyForBuyLottos();
        this.manualLottosQuantity = LottoView.askManualLottosQuantity(lottosQuantity);
        this.autoLottosQuantity = lottosQuantity - manualLottosQuantity;
    }

    private void initLottoView() {
        List<Lotto> manualLottos = LottoView.askManualLottos(this.manualLottosQuantity);
        Lottos lottos = new Lottos(manualLottos, this.autoLottosQuantity);
        this.lottoView = new LottoView(lottos);
    }

    private void printInfosWithResult() {
        lottoView.printLottos(this.manualLottosQuantity);

        Result result = lottoView.askResult();
        BonusNumber bonusNumber = lottoView.askBonusNumber(result);

        lottoView.printMatches(result, bonusNumber);
        lottoView.printEarningRate();
    }
}
