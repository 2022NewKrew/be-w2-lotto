package lotto.step3;

import lotto.step1.controller.LottoController;
import lotto.step1.exception.LottoGameException;
import lotto.step1.util.consoleInput.InputConsole;
import lotto.step1.view.View;
import lotto.step3.controller.NonAutoLottoAddBonusBallController;
import lotto.step3.view.consoleView.NonAutoLottoAddBonusBallConsoleView;

public class Step3LottoGame {
    private final View lottoConsoleView;

    public Step3LottoGame() {
        final LottoController lottoController = new NonAutoLottoAddBonusBallController();
        lottoConsoleView = new NonAutoLottoAddBonusBallConsoleView(lottoController);
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
