package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.IOException;

public class LottoController {
    public void run() throws IOException {
        final int purchasePrice = InputView.inputpurchasePrice();

        final PurchaseLotto purchaseLotto = PurchaseLotto.of(purchasePrice);
        OutputView.drawPurchaseLotto(purchaseLotto);

        final String lastWeekNumber = InputView.inputLastWeekNumbers();
        final Lotto lastWeekLotto = Lotto.of(lastWeekNumber);

        LottoResult lottoResult = new LottoResult(purchasePrice, lastWeekLotto, purchaseLotto);
        OutputView.drawStatistics(lottoResult);
    }
}
