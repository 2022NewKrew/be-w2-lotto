package controller;

import domain.LottoGenerator;
import view.InputView;

public class LottoGame {
    public void run() {
        int purchasedLottoNumbers = InputView.inputPurchaseAmount();

        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoGenerator.createAutoLotto();


    }
}
