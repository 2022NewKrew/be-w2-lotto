import view.input.InputView;
import view.input.PriceInputView;
import view.output.LottoOutputView;
import view.output.OutputView;
import view.util.ResourceManager;

import java.util.List;

public class LottoMain {
    private final InputView inputView = new PriceInputView();
    private final OutputView outputView = new LottoOutputView();

    public void start(){
        Long lottoBundleId = inputView.inputPrice();
        outputView.showPurchasedLottoBundle(lottoBundleId);
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        outputView.showPurchasedLottoResults(winningNumbers, lottoBundleId);
        ResourceManager.close();
    }
}
