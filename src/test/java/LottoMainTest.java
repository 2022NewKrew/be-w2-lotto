import dto.LastWeekWinningNumberDTO;
import org.junit.jupiter.api.Test;
import view.input.InputView;
import view.input.PriceInputView;
import view.output.LottoOutputView;
import view.output.OutputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LottoMainTest {
    private final InputView inputView = new PriceInputView();
    private final OutputView outputView = new LottoOutputView();

    @Test
    public void start() {
        String input = "50000\n3\n3,7,8,10,15,23\n3,4,8,11,15,23\n3,7,8,11,15,23\n3,7,8,11,15,23\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Long lottoBundleId = inputView.inputPrice();
        outputView.showPurchasedLottoBundle(lottoBundleId);
        LastWeekWinningNumberDTO lastWeekWinningNumberDTO = inputView.inputWinningNumbers();
        outputView.showPurchasedLottoResults(lastWeekWinningNumberDTO, lottoBundleId);
    }

}