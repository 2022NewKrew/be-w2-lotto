package view.console.output;

import controller.ConsoleOutputController;
import controller.OutputController;
import dto.LastWeekWinningNumber;

public class LottoOutputView implements OutputView {
    private final OutputController outputController = new ConsoleOutputController();

    @Override
    public void showPurchasedLottoBundle(Long lottoBundleId) {
        String lottoBundleStr = outputController.showPurchasedLottoBundle(lottoBundleId);
        System.out.println(lottoBundleStr);
    }

    @Override
    public void showPurchasedLottoResults(LastWeekWinningNumber lastWeekWinningNumberDTO, Long lottoBundleId) {
        String lottoResult = outputController.showPurchasedLottoResults(lastWeekWinningNumberDTO, lottoBundleId);
        System.out.println(lottoResult);
    }
}
