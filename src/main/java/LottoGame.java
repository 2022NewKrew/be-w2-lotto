import domain.Lotto;
import domain.WinningLotto;
import exception.InvalidInputException;
import service.LottoService;
import service.ResultService;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static utils.Symbol.MANUAL_INPUT_MESSAGE;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ResultService resultService = new ResultService();

    public void start() throws InvalidInputException {
        int purchaseAmount = inputView.getPurchaseAmount();
        int manualLottoCount = inputView.getManualLottoCount(purchaseAmount);

        List<Lotto> manualLottolist = new ArrayList<>();
        System.out.println("\n" + MANUAL_INPUT_MESSAGE);
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottolist.add(inputView.getManualLotto());
        }

        LottoService lottoService = new LottoService(purchaseAmount, manualLottolist);
        List<Lotto> lottos = lottoService.getLottos();

        outputView.printPurchaseLottoList(lottos, manualLottoCount);

        WinningLotto winningLotto = inputView.getWinningLotto();

        resultService.generateResult(lottos, winningLotto);
        outputView.printResult(resultService);
    }

}
