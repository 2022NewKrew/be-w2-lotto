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

        ResultView.printLottoNumbers(lottos.exportLottosDTO(), lottoCount.manualLottoCount(), lottoCount.autoLottoCount());

        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningNumbers);
        ResultView.printResult(winningStatistics.statistics(), winningStatistics.profits());
    }

    public void addManualLotto(Lottos lottos, long manualLottoCount) {
        for (int i = 0; i < manualLottoCount; i++) {
            lottos.addLotto(LottoStore.purchase(InputView.enterLottoManualNumbers()));
        }
    }
}
