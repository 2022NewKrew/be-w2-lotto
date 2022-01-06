package lotto.controller;

import lotto.buyer.LottoBuyer;
import lotto.view.InputView;

public class LottoGameController {
    public void start() {
        LottoBuyer lottoBuyer = new LottoBuyer();

        InputView.openScanner();

        lottoBuyer.buyLotto();
        lottoBuyer.checkAllLotto();

        InputView.closeScanner();
    }
}
