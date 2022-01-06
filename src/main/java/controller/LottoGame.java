package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.LottoResult;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Set;

public class LottoGame {
    public static void start() {
        long purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> lottoList = LottoMachine.buySeveralLotto(purchaseAmount);
        ResultView.printLottoList(lottoList);

        Set<Integer> lastWeekWinningNumbers = InputView.inputLastWeekWinningNumber();
        LottoResult lottoResult = new LottoResult(lastWeekWinningNumbers);
        ResultView.printLottoResult(lottoResult.winningLottoCount(lottoList));
        ResultView.printRateOfReturn(lottoResult.rateOfReturn(purchaseAmount));
    }
}
