package lotto;

import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoController.start(new ConsoleInputView(), new ConsoleOutputView());
    }
}
