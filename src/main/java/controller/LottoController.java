package controller;

import domain.*;
import view.InputView;
import view.ResultView;

public class LottoController {
    public void run() {
        LottoCount lottoCount = new LottoCount(InputView.enterPurchasingAmount(), InputView.enterLottoManualCount());

        Lottos lottos = new Lottos();

        if(lottoCount.manualLottoCount() > 0) {
            InputView.messageLottoManualCount();
            addManualLotto(lottos, lottoCount.manualLottoCount());
        }
        lottos.addLottos(LottoStore.purchase(lottoCount.autoLottoCount()));

        ResultView.printLottoNumbers(lottos, lottoCount.manualLottoCount());

        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        ResultView.printResult(new WinningStatistics(lottos, winningNumbers));
    }

    public void addManualLotto(Lottos lottos, long manualLottoCount) {
        for (int i = 0; i < manualLottoCount; i++) {
            lottos.addLotto(LottoStore.purchase(InputView.enterLottoManualNumbers()));
        }
    }
}
