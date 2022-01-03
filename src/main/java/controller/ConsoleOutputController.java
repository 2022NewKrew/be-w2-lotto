package controller;

import service.AutoLottoService;
import service.LottoService;

public class ConsoleOutputController implements OutputController{
    private final LottoService lottoService = new AutoLottoService();

    @Override
    public String showPurchasedLottoBundle(Long lottoBundleId) {
        return lottoService.getPurchasedLottoBundleString(lottoBundleId);
    }
}
