package lotto;

import lotto.controller.LottoApplication;
import lotto.controller.LottoConsoleApplication;
import lotto.controller.LottoWebApplication;
import lotto.view.LottoConsoleView;
import lotto.view.LottoView;
import lotto.view.LottoWebView;


public class Main {

    public static void main(String[] args) {
//        LottoApplication app = new LottoWebApplication();
        LottoApplication app = new LottoConsoleApplication();
        app.start();

    }
}
