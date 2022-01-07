package lotto.step2.view.consoleView;

import lotto.step1.controller.LottoController;
import lotto.step1.exception.ConsoleInputCountExceededException;
import lotto.step1.view.consoleView.ConsoleView;
import lotto.step1.view.consoleView.PurchaseLottoView;

public class LottoAddBonusBallConsoleView implements ConsoleView {

    private final ConsoleView purchaseLottoView;
    private final ConsoleView confirmResultView;

    public LottoAddBonusBallConsoleView(LottoController lottoController) {
        purchaseLottoView = new PurchaseLottoView(lottoController);
        confirmResultView = new ConfirmResultAddBonusBallView(lottoController);
    }

    @Override
    public void print() throws ConsoleInputCountExceededException {
        purchaseLottoView.print();
        confirmResultView.print();
    }
}
