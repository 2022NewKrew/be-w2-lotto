package view.console;

import controller.Controller;

public class ConsoleLottoView implements ConsoleView {
    private final LottoPurchaseView lottoPurchaseView;
    private final LottoResultView lottoResultView;

    public ConsoleLottoView(Controller consoleController) {
        this.lottoPurchaseView = new LottoPurchaseView(consoleController);
        this.lottoResultView = new LottoResultView(consoleController);
    }

    @Override
    public void print() throws Exception {
        lottoPurchaseView.print();
        lottoResultView.print();
    }
}
