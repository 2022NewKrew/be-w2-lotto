package lotto.step1;

import lotto.step1.controller.LottoController;
import lotto.step1.exception.LottoGameException;
import lotto.step1.util.consoleInput.InputConsole;
import lotto.step1.view.View;
import lotto.step1.view.consoleView.LottoConsoleView;

public class Step1LottoGame {
    private final View lottoConsoleView;

    public Step1LottoGame() {
        final LottoController lottoController = new LottoController();

        lottoConsoleView = new LottoConsoleView(lottoController);
    }

    public void run() {
        try {
            lottoConsoleView.print();
        } catch (LottoGameException | ClassCastException ex) {
            System.out.println(ex.getMessage());
            System.out.println("비정상적인 동작으로 종료합니다.");
        } finally {
            InputConsole.sc.close();
        }
    }
}
