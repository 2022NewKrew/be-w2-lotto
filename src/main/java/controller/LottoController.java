package controller;

import domain.*;
import view.InputView;
import view.ResultView;

public class LottoController {
    public void run() {
        Lottos lottos = LottoStore.purchase(new Money(InputView.enterPurchasingAmount()));
        ResultView.printLottoNumbers(lottos);
        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        ResultView.printResult(new WinningStatistics(lottos, winningNumbers));
    }
}
