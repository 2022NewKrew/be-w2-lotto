import org.junit.jupiter.api.Test;
import view.input.InputView;
import view.input.PriceInputView;
import view.output.LottoOutputView;
import view.output.OutputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMainTest {
    private final InputView inputView = new PriceInputView();
    private final OutputView outputView = new LottoOutputView();

    @Test
    public void start(){
        String input = "500000\n6,7,8,10,15,23";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Long lottoBundleId = inputView.inputPrice();
        outputView.showPurchasedLottoBundle(lottoBundleId);
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        outputView.showPurchasedLottoResults(winningNumbers, lottoBundleId);
    }

}