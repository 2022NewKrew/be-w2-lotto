import domain.Lotto;
import domain.WinningLotto;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start(){
        int purchaseAmount = inputView.getPurchaseAmount();
        int manualLottoCount = inputView.getManualLottoCount();

        LottoService lottoService = new LottoService(purchaseAmount,manualLottoCount);
        ArrayList<Lotto> lottos = lottoService.getLottos();

        outputView.printPurchaseLottoList(lottos);

        WinningLotto winningLotto = inputView.getWinningLotto();
//
//        ResultService resultService = new ResultService(lottos, winningLotto);
//        outputView.printResult(resultService);
    }

}
