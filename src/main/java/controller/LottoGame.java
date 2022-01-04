package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.ResultCalculator;
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
        ResultView.printLottoResult(ResultCalculator.calculateLottoResult(lastWeekWinningNumbers));
        ResultView.printRateOfReturn(ResultCalculator.calculateRateOfReturn(lastWeekWinningNumbers));
    }
}
