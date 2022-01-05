package controller;

import domain.lotto.*;
import service.LottoInputService;
import view.LottoRenderer;

import java.util.List;

public class LottoGameController {

    private final LottoInputService lottoInputService;

    public LottoGameController() {
        this.lottoInputService = new LottoInputService();
    }

    public void start() {
        LottoGameInfo lottoGameInfo = lottoInputService.inputPurchaseParam();

        List<Lotto> lottoList = lottoGameInfo.getManualPurchaseLottoList();
        lottoList.addAll(LottoGenerator.generateAllLotto(lottoGameInfo));
        LottoRenderer.renderLotto(lottoList, lottoGameInfo);

        WinningLotto winningLotto = lottoInputService.inputWinLottoNumbers();

        LottoTotalResult lottoTotalResult = LottoCalculator.calculate(lottoGameInfo.getInputMoney(), lottoList, winningLotto);
        renderResult(lottoTotalResult);
    }

    private void renderResult(LottoTotalResult lottoTotalResult) {
        LottoRenderer.renderResult(lottoTotalResult);
        LottoRenderer.renderEarningRatio(lottoTotalResult);
    }

}
