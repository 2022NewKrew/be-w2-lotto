package controller;

import domain.*;
import view.InputView;
import view.ResultView;

public class LottoController {
    public void run() {
        LottoCount lottoCount = new LottoCount(InputView.enterPurchasingAmount(), InputView.enterLottoManualCount());

        Lottos lottos = new Lottos();
        InputView.messageLottoManualCount(lottoCount.manualLottoCount());
        for (int i = 0; i < lottoCount.manualLottoCount(); i++) {
            lottos.addLotto(LottoStore.purchase(InputView.enterLottoManualNumbers()));
        }
        lottos.addLottos(LottoStore.purchase(lottoCount.autoLottoCount()));

        ResultView.printLottoNumbers(lottos, lottoCount.manualLottoCount());

        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        ResultView.printResult(new WinningStatistics(lottos, winningNumbers));
    }
}
