package lotto.domain;

import lotto.view.View;

import java.util.List;

public class LottoGame {

    private final View view;

    public LottoGame(View view) {
        this.view = view;
    }

    public void run() {
        Integer purchaseAmount = view.readPurchaseAmountForLotto();
        Lotto lotto = new Lotto(purchaseAmount);
        view.printLottoCount(lotto.getLottoCount());
        view.printLotto(lotto.getLottoRows());

        List<Integer> winningNumbers = view.readWinningNumbers();
        lotto.calculateLottoWinningResult(winningNumbers);
        LottoWinningResult lottoWinningResult = lotto.getLottoWinningResult();
        view.printLottoWinningResult(lottoWinningResult);
        view.printYield(lottoWinningResult.getYield(lotto.getWholeLottoPrice()));
    }
}
