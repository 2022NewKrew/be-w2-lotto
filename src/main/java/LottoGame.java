import domain.Lotto;
import domain.WinningLotto;
import exception.InvalidInputException;
import service.LottoService;
import service.ResultService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ResultService resultService = new ResultService();

    public void start() throws InvalidInputException {
        int purchaseAmount = inputView.getPurchaseAmount();
        int manualLottoCount = inputView.getManualLottoCount(purchaseAmount);
        LottoService lottoService = new LottoService(purchaseAmount, manualLottoCount);
        List<Lotto> lottos = lottoService.getLottos();

        outputView.printPurchaseLottoList(lottos, manualLottoCount);

        WinningLotto winningLotto = inputView.getWinningLotto();

        resultService.generateResult(lottos, winningLotto);
        outputView.printResult(resultService);
    }

}
