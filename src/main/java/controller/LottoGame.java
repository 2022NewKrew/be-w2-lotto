package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.LottoResult;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoGame {
    private List<Lotto> lottoList;
    private int purchaseAmount;

    public void start() {
        purchaseAmount = InputView.inputPurchaseAmount();
        lottoList = LottoMachine.buySeveralLotto(purchaseAmount);
        ResultView.printLottoList(lottoList);

        List<Integer> lastWeekWinningNumbers = InputView.inputLastWeekWinningNumber();
        ResultView.printLottoResult(LottoResult.calculateLottoResult(lastWeekWinningNumbers));
        ResultView.printRateOfReturn(LottoResult.calculateRateOfReturn(lastWeekWinningNumbers));
    }
}
