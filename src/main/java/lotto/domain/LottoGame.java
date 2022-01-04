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
        LottoTicket lotto = new LottoTicket(purchaseAmount);
        view.printLottoCount(lotto.getLottoCount());
        view.printLotto(lotto.getLottoList());

        List<Integer> winningNumbers = view.readWinningNumbers();
        LottoWinningResult lottoWinningResult = lotto.getLottoWinningResult(winningNumbers);
        view.printLottoWinningResult(lottoWinningResult);
        view.printYield(lottoWinningResult.getYield(lotto.getWholeLottoPrice()));
    }

}
