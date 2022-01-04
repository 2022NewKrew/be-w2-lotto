package controller;

import domain.*;
import view.InputView;
import view.ResultView;

public class LottoController {
    private static final String MESSAGE_EXCEED_AMOUNT = "구입 금액을 초과하여 수동 로또를 구입할 수 없습니다.";

    public void run() {
        Money money = new Money(InputView.enterPurchasingAmount());

        long manualLottoCount = InputView.enterLottoManualCount();
        if(money.lottoCount() < manualLottoCount) {
            throw new IllegalArgumentException(MESSAGE_EXCEED_AMOUNT);
        }

        Lottos lottos = new Lottos();
        InputView.messageLottoManualCount(manualLottoCount);
        for (int i = 0; i < manualLottoCount; i++) {
            lottos.addLotto(LottoStore.purchase(InputView.enterLottoManualNumbers()));
        }

        money.reduction(manualLottoCount);
        lottos.addLottos(LottoStore.purchase(money));

        ResultView.printLottoNumbers(lottos, manualLottoCount);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        ResultView.printResult(new WinningStatistics(lottos, winningNumbers));
    }
}
