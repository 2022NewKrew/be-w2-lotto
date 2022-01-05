package controller;

import dto.LastWeekWinningNumber;
import dto.LottoResult;
import service.AutoLottoService;
import service.LottoService;

public class ConsoleOutputController implements OutputController {
    private final LottoService lottoService = new AutoLottoService();

    @Override
    public String showPurchasedLottoBundle(Long lottoBundleId) {
        return lottoService.getPurchasedLottoBundleString(lottoBundleId);
    }

    @Override
    public String showPurchasedLottoResults(LastWeekWinningNumber lastWeekWinningNumber, Long lottoBundleId) {
        return lottoService.getLottoResultDTO(lastWeekWinningNumber, lottoBundleId).toString();
    }
}
