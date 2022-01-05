package lotto.step1.view.consoleView;

import lotto.step1.controller.LottoController;
import lotto.step1.exception.LottoGameException;

public class LottoConsoleView implements ConsoleView {

    private final ConsoleView purchaseLottoView;
    private final ConsoleView confirmResultView;

    public LottoConsoleView(LottoController lottoController) {
        purchaseLottoView = new PurchaseLottoView(lottoController);
        confirmResultView = new ConfirmResultView(lottoController);
    }

    @Override
    public void print() throws LottoGameException {
        purchaseLottoView.print();
        confirmResultView.print();
    }
}
