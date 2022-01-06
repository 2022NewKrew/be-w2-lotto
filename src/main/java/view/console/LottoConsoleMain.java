package view.console;

import dto.LastWeekWinningNumber;
import view.console.input.InputView;
import view.console.input.PriceInputView;
import view.console.output.LottoOutputView;
import view.console.output.OutputView;
import view.util.ResourceManager;

public class LottoConsoleMain {
    private final InputView inputView = new PriceInputView();
    private final OutputView outputView = new LottoOutputView();

    public void start() {
        Long lottoBundleId = inputView.inputPrice();
        outputView.showPurchasedLottoBundle(lottoBundleId);
        LastWeekWinningNumber lastWeekWinningNumberDTO = inputView.inputWinningNumbers();
        outputView.showPurchasedLottoResults(lastWeekWinningNumberDTO, lottoBundleId);
        ResourceManager.close();
    }
}
