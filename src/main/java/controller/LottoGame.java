package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.LottoResult;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoGame {

    public void start() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> lottoList = LottoMachine.buySeveralLotto(purchaseAmount);
        ResultView.printLottoList(lottoList);

        List<Integer> lastWeekWinningNumbers = InputView.inputLastWeekWinningNumber();
        LottoResult lottoResult = new LottoResult(lastWeekWinningNumbers);
        ResultView.printLottoResult(lottoResult.winningLottoCount(lottoList));
        ResultView.printRateOfReturn(lottoResult.rateOfReturn(purchaseAmount));
    }
}
