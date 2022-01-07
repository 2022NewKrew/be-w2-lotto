package lotto;

import lotto.manager.LottoConsoleManager;
import lotto.manager.LottoWebManager;

public class Application {
    public static void main(String[] args) {
        LottoWebManager.getInstance().run();
    }
}
