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
        LottoGameInfo lottoGameInfo = inputPurchaseParamAndValidate();

        List<Lotto> lottoList = lottoGameInfo.getManualPurchaseLottoList();
        lottoList.addAll(LottoGenerator.generateAllLotto(lottoGameInfo));
        LottoRenderer.renderLotto(lottoList, lottoGameInfo);

        WinningLotto winningLotto = inputWinningLottoNumbersAndValidate();

        LottoTotalResult lottoTotalResult = LottoCalculator.calculate(lottoGameInfo.getInputMoney(), lottoList, winningLotto);
        renderResult(lottoTotalResult);
    }

    private LottoGameInfo inputPurchaseParamAndValidate() {
        LottoGameInfo lottoGameInfo = null;
        while (lottoGameInfo == null) {
            lottoGameInfo = inputPurchaseParam();
        }
        return lottoGameInfo;
    }

    private LottoGameInfo inputPurchaseParam() {
        try {
            return lottoInputService.inputPurchaseParam();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private WinningLotto inputWinningLottoNumbersAndValidate() {
        WinningLotto winningLotto = null;
        while (winningLotto == null) {
            winningLotto = inputWinningLottoNumbers();
        }
        return winningLotto;
    }

    private WinningLotto inputWinningLottoNumbers() {
        try {
            return lottoInputService.inputWinningLottoNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void renderResult(LottoTotalResult lottoTotalResult) {
        LottoRenderer.renderResult(lottoTotalResult);
        LottoRenderer.renderEarningRatio(lottoTotalResult);
    }

}
