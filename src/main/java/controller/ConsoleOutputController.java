package controller;

import dto.LastWeekWinningNumber;
import service.AutoLottoService;
import service.LottoService;

public class ConsoleOutputController implements OutputController {
    private final LottoService lottoService = new AutoLottoService();

    @Override
    public String showPurchasedLottoBundle(Long lottoBundleId) {
        return lottoService.getPurchasedLottoBundle(lottoBundleId).toString();
    }

    @Override
    public String showPurchasedLottoResults(LastWeekWinningNumber lastWeekWinningNumber, Long lottoBundleId) {
        return lottoService.getLottoResult(lastWeekWinningNumber, lottoBundleId).toString();
    }
}
