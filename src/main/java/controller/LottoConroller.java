package controller;

import domain.*;

public class LottoConroller {
    public void run() {
        Lottos lottos = LottoStore.purchase(new Money(InputView.enterPurchasingAmount()));
        ResultView.printLottoNumbers(lottos);
        Lotto winningLotto = new Lotto(InputView.enterWinningNumber());
        ResultView.printResult(new WinningStatistics(lottos, winningLotto));
    }
}
