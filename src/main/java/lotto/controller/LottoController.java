package lotto.controller;

import lotto.domain.model.LottoNumbers;
import lotto.domain.model.LottoResult;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.IOException;

public class LottoController {
    public void run() throws IOException {
        final int purchasePrice = InputView.inputPurchasePrice();

        final Lottos lottos = Lottos.from(purchasePrice);
        OutputView.drawPurchaseLotto(lottos);

        final String winningLottoNumbers = InputView.inputWinningLottoNumbers();
        final int bonusBall = InputView.inputBonusBall();
        final WinningLotto winningLotto =
                new WinningLotto(bonusBall, LottoNumbers.getWinningLottoNumbers(winningLottoNumbers));

        LottoResult lottoResult = LottoResult.of(purchasePrice, winningLotto, lottos);
        OutputView.drawStatistics(lottoResult);
    }
}
