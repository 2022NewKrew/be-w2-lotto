package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.LottoResult;
import exceptions.InvalidPurchaseAmount;
import messages.ErrorMessage;
import validation.Validation;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoGame {

    public void start() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        Validation.notLessThanInt(purchaseAmount, 0, new InvalidPurchaseAmount(ErrorMessage.NEGATIVE_PURCHASE_AMOUNT.getMessage()));
        List<Lotto> lottoList = LottoMachine.buySeveralLotto(purchaseAmount);
        ResultView.printLottoList(lottoList);

        List<Integer> lastWeekWinningNumbers = InputView.inputLastWeekWinningNumber();
        Validation.lengthShouldBe(lastWeekWinningNumbers, 6, new InvalidPurchaseAmount(ErrorMessage.SIX_WINNING_NUMBER.getMessage()));
        ResultView.printLottoResult(LottoResult.winningLottoCount(lastWeekWinningNumbers, lottoList));
        ResultView.printRateOfReturn(LottoResult.rateOfReturn(lastWeekWinningNumbers, purchaseAmount));
    }
}
