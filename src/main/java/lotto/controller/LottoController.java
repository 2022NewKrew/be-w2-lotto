package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.IOException;

public class LottoController {
    public void run() throws IOException {
        final int purchasePrice = InputView.inputPurchasePrice();

        final PurchaseLotto purchaseLotto = PurchaseLotto.of(purchasePrice);
        OutputView.drawPurchaseLotto(purchaseLotto);

        final String winningLottoNumbers = InputView.inputWinningLottoNumbers();
        final int bonusBall = InputView.inputBonusBall();
        final WinningLotto winningLotto = WinningLotto.of(bonusBall, winningLottoNumbers);

        LottoResult lottoResult = new LottoResult(purchasePrice, winningLotto, purchaseLotto);
        OutputView.drawStatistics(lottoResult);
    }
}
