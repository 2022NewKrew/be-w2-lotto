package lotto;

import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new ConsoleInputView(), new ConsoleOutputView());
        lottoController.start();
    }
}
