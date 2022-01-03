package lotto.step1.view.consoleView;

import lotto.step1.controller.ConsoleLottoController;
import lotto.step1.exception.ConsoleInputCountExceededException;

public class LottoConsoleView implements ConsoleView {

    private final PurchaseLottoView purchaseLottoView;
    private final ConfirmResultView confirmResultView;

    public LottoConsoleView(ConsoleLottoController consoleLottoController) {
        purchaseLottoView = new PurchaseLottoView(consoleLottoController);
        confirmResultView = new ConfirmResultView(consoleLottoController);
    }

    @Override
    public void print() throws ConsoleInputCountExceededException {
        purchaseLottoView.print();
        confirmResultView.print();
    }
}
