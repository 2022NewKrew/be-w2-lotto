package controller;

import dto.LottoResultDTO;
import service.AutoLottoService;
import service.LottoService;

import java.util.List;

public class ConsoleOutputController implements OutputController{
    private final LottoService lottoService = new AutoLottoService();

    @Override
    public String showPurchasedLottoBundle(Long lottoBundleId) {
        return lottoService.getPurchasedLottoBundleString(lottoBundleId);
    }

    @Override
    public LottoResultDTO showPurchasedLottoResults(List<Integer> winningNumbers, Long lottoBundleId) {
        return lottoService.getLottoResultDTO(winningNumbers, lottoBundleId);
    }
}
