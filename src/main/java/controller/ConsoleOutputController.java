package controller;

import dto.LastWeekWinningNumberDTO;
import dto.LottoResultDTO;
import service.AutoLottoService;
import service.LottoService;

import java.util.List;

public class ConsoleOutputController implements OutputController {
    private final LottoService lottoService = new AutoLottoService();

    @Override
    public String showPurchasedLottoBundle(Long lottoBundleId) {
        return lottoService.getPurchasedLottoBundleString(lottoBundleId);
    }

    @Override
    public LottoResultDTO showPurchasedLottoResults(LastWeekWinningNumberDTO lastWeekWinningNumberDTO, Long lottoBundleId) {
        return lottoService.getLottoResultDTO(lastWeekWinningNumberDTO, lottoBundleId);
    }
}
