package lotto.domain;

import lotto.view.View;

import java.util.List;

public class LottoGame {

    private final View view;

    public LottoGame(View view) {
        this.view = view;
    }

    public void run() {
        int purchaseAmount = view.readPurchaseAmountForLotto();
        int manualPurchaseCountForLotto = view.readManualPurchaseCountForLotto(purchaseAmount);
        List<List<Integer>> manualLottoNumbers = view.readManualLottoNumbers(manualPurchaseCountForLotto);
        LottoTicket lotto = new LottoTicket(purchaseAmount, manualLottoNumbers);
        view.printLottoCount(lotto.getManualLottoCount(), lotto.getAutomaticLottoCount());
        view.printLotto(lotto.getLottoList());

        List<Integer> winningNumbers = view.readWinningNumbers();
        int bonusBallNumber = view.readBonusBallNumber();
        LottoWinningResult lottoWinningResult = lotto.getLottoWinningResult(winningNumbers, bonusBallNumber);
        view.printLottoWinningResult(lottoWinningResult);
        view.printYield(lottoWinningResult.getYield(lotto.getWholeLottoPrice()));
    }

}
