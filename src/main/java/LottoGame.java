import domain.Lotto;
import domain.Number;
import domain.Result;
import domain.WinningLotto;
import enums.Rank;
import service.LottoService;
import service.ResultService;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private ResultService resultService = new ResultService();

    public void start() {
        int purchaseAmount = inputView.getPurchaseAmount();
        int manualLottoCount = inputView.getManualLottoCount();
        LottoService lottoService = new LottoService(purchaseAmount, manualLottoCount);
        ArrayList<Lotto> lottos = lottoService.getLottos();

        outputView.printPurchaseLottoList(lottos);

        WinningLotto winningLotto = inputView.getWinningLotto();

        resultService.generateResult(lottos, winningLotto);
        outputView.printResult(resultService);
    }

}
