package lotto.step2;

import lotto.step1.controller.LottoController;
import lotto.step1.exception.LottoGameException;
import lotto.step1.util.consoleInput.InputConsole;
import lotto.step1.view.View;
import lotto.step2.controller.LottoAddBonusBallController;
import lotto.step2.view.consoleView.LottoAddBonusBallConsoleView;

public class Step2LottoGame {
    private final View lottoConsoleView;

    public Step2LottoGame() {
        final LottoController lottoController = new LottoAddBonusBallController();
        lottoConsoleView = new LottoAddBonusBallConsoleView(lottoController);
    }

    public void run() {
        try {
            lottoConsoleView.print();
        } catch (LottoGameException lottoGameException) {
            System.out.println(lottoGameException.getMessage());
            System.out.println("비정상적인 동작으로 종료합니다.");
        } finally {
            InputConsole.sc.close();
        }
    }
}
