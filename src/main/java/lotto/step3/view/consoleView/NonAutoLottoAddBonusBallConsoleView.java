package lotto.step3.view.consoleView;

import lotto.step1.controller.LottoController;
import lotto.step1.exception.ConsoleInputCountExceededException;
import lotto.step1.view.consoleView.ConsoleView;
import lotto.step2.view.consoleView.ConfirmResultAddBonusBallView;

public class NonAutoLottoAddBonusBallConsoleView implements ConsoleView {
    private final ConsoleView purchaseLottoView;
    private final ConsoleView confirmResultView;

    public NonAutoLottoAddBonusBallConsoleView(LottoController lottoController) {
        purchaseLottoView = new NonAutoPurchaseLottoView(lottoController);
        confirmResultView = new ConfirmResultAddBonusBallView(lottoController);
    }

    @Override
    public void print() throws ConsoleInputCountExceededException {
        purchaseLottoView.print();
        confirmResultView.print();
    }
}
