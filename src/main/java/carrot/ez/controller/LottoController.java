package carrot.ez.controller;

import carrot.ez.dto.response.LottosDto;
import carrot.ez.dto.response.LottosResultDto;
import carrot.ez.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }


    public LottosDto buyLottos(String inputMoney, String manualNumbers) {
        return lottoService.buyLottos(inputMoney, manualNumbers);
    }

    public LottosResultDto matchLottos(String id, String winningNumber, String bonusNumber) {
        return lottoService.matchLottos(id, winningNumber, bonusNumber);
    }
}
