package view.output;

import controller.ConsoleOutputController;
import controller.OutputController;
import dto.LastWeekWinningNumberDTO;
import dto.LottoResultDTO;

import java.util.List;

public class LottoOutputView implements OutputView{
    private final OutputController outputController = new ConsoleOutputController();

    @Override
    public void showPurchasedLottoBundle(Long lottoBundleId) {
        String lottoBundleStr = outputController.showPurchasedLottoBundle(lottoBundleId);
        System.out.println(lottoBundleStr);
    }

    @Override
    public void showPurchasedLottoResults(LastWeekWinningNumberDTO lastWeekWinningNumberDTO, Long lottoBundleId) {
        LottoResultDTO lottoResultDTO = outputController.showPurchasedLottoResults(lastWeekWinningNumberDTO, lottoBundleId);
        System.out.println(lottoResultDTO);
    }
}
