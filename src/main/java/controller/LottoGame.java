package controller;

import view.InputView;

public class LottoGame {
    public void run() {
        int purchasedLottoNumbers = InputView.inputPurchaseAmount();
        System.out.println(purchasedLottoNumbers);

    }
}
