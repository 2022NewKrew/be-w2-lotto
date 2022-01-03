package view.output;

import controller.ConsoleOutputController;
import controller.OutputController;

public class LottoOutputView implements OutputView{
    private final OutputController outputController = new ConsoleOutputController();

    @Override
    public void showPurchasedLottoBundle(Long lottoBundleId) {
        outputController.showPurchasedLottoBundle(lottoBundleId);
    }
}
