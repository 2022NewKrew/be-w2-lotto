package controller;

import domain.lotto.*;
import dto.LottoRequest;
import dto.LottoResponse;
import dto.LottoResultResponse;
import service.LottoInputService;
import service.LottoService;
import view.LottoRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameController {

    private final LottoInputService lottoInputService;
    private final LottoService lottoService;
    private List<Lotto> lottos;

    public LottoGameController() {
        this.lottoInputService = new LottoInputService();
        this.lottoService = new LottoService();
    }

    public List<LottoResponse> createLotto(String inputMoney, String inputManualRequests) {

        int money = lottoInputService.getIntegerFromString(inputMoney);
        List<LottoRequest> lottoRequests = new ArrayList<>();
        if (!inputManualRequests.isEmpty()) {
            lottoRequests = lottoInputService.getManualLottoRequests(inputManualRequests);
        }

        lottos = lottoService.createLotto(money, lottoRequests);
        return lottos.stream()
                .map(LottoResponse::new)
                .collect(Collectors.toList());
    }

    public LottoResultResponse getLottoResult(String winningNumber, String bonusNumber) {
        int bonusLottoNumber = lottoInputService.getIntegerFromString(bonusNumber);

        LottoRequest lottoRequest = lottoInputService.parseLottoRequest(winningNumber);
        WinningLotto winningLotto = lottoService.createWinningLotto(lottoRequest, bonusLottoNumber);

        LottoTotalResult totalResult = LottoCalculator.calculate(lottos, winningLotto);
        return new LottoResultResponse(totalResult);
    }

//    public void start() {
//        LottoGameInfo lottoGameInfo = null;
//
//        WinningLotto winningLotto = inputWinningLottoNumbersAndValidate();
//
//        LottoTotalResult lottoTotalResult = LottoCalculator.calculate(lottoGameInfo.getInputMoney(), lottoList, winningLotto);
//        renderResult(lottoTotalResult);
//    }

//    private WinningLotto inputWinningLottoNumbersAndValidate() {
//        WinningLotto winningLotto = null;
//        while (winningLotto == null) {
//            winningLotto = inputWinningLottoNumbers();
//        }
//        return winningLotto;
//    }
//
//    private WinningLotto inputWinningLottoNumbers() {
//        try {
//            return lottoInputService.inputWinningLottoNumbers();
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//    private void renderResult(LottoTotalResult lottoTotalResult) {
//        LottoRenderer.renderResult(lottoTotalResult);
//        LottoRenderer.renderEarningRatio(lottoTotalResult);
//    }

}
