package controller;

import domain.lotto.*;
import dto.LottoRequest;
import service.LottoInputService;
import service.LottoService;
import view.LottoRenderer;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    private final LottoInputService lottoInputService;
    private final LottoService lottoService;

    public LottoGameController() {
        this.lottoInputService = new LottoInputService();
        this.lottoService = new LottoService();
    }

    public List<Lotto> createLotto(String inputMoney, String inputManualRequests) {

        int money = lottoInputService.getMoney(inputMoney);
        List<LottoRequest> lottoRequests = new ArrayList<>();
        if (!inputManualRequests.isEmpty()) {
            lottoRequests = lottoInputService.getManualLottoRequests(inputManualRequests);
        }
        return lottoService.createLotto(money, lottoRequests);
    }

    public void start() {
        LottoGameInfo lottoGameInfo = null;

        List<Lotto> lottoList = lottoGameInfo.getManualPurchaseLottoList();
        lottoList.addAll(LottoGenerator.generateAllLotto(lottoGameInfo));
        LottoRenderer.renderLotto(lottoList, lottoGameInfo);

        WinningLotto winningLotto = inputWinningLottoNumbersAndValidate();

        LottoTotalResult lottoTotalResult = LottoCalculator.calculate(lottoGameInfo.getInputMoney(), lottoList, winningLotto);
        renderResult(lottoTotalResult);
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
