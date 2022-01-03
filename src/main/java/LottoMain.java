import view.input.InputView;
import view.input.PriceInputView;
import view.output.LottoOutputView;
import view.output.OutputView;

public class LottoMain {
    private final InputView inputView = new PriceInputView();
    private final OutputView outputView = new LottoOutputView();

    public void start(){
        Long lottoBundleId = inputView.inputPrice();
        outputView.showPurchasedLottoBundle(lottoBundleId);
        
    }
}
