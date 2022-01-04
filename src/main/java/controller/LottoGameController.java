package controller;

import domain.lotto.*;
import service.LottoGameService;
import service.LottoInputService;
import view.LottoRenderer;

public class LottoGameController {

    private LottoInputService lottoInputService;
    private LottoGameService lottoGameService;

    public void initialize() {
        lottoInputService = new LottoInputService();
        lottoGameService = new LottoGameService();
    }

    public void start() {
        LottoGameInfo lottoGameInfo = lottoInputService.inputPurchaseParam();

        lottoGameService.generateLotto(lottoGameInfo);
        lottoGameService.renderLottoList();

        Lotto winLotto = lottoInputService.inputWinLottoNumbers();
        int bonusLottoNumber = lottoInputService.inputBonusLottoNumber();

        LottoTotalResult lottoTotalResult = lottoGameService.calcLottoResult(winLotto, bonusLottoNumber, lottoGameInfo.getInputMoney());
        renderResult(lottoTotalResult);
    }

    private void renderResult(LottoTotalResult lottoTotalResult) {
        LottoRenderer.renderResult(lottoTotalResult);
        LottoRenderer.renderEarningRatio(lottoTotalResult);
    }

}
