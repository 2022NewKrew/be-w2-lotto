package lotto;

import lotto.view.LottoConsoleView;
import lotto.view.LottoView;
import lotto.view.LottoWebView;


public class Main {

    public static void main(String[] args) {
//        LottoView view = new LottoConsoleView();
        LottoView view = new LottoWebView();
        view.start();

    }
}
