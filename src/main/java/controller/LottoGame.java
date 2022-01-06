package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.LottoResult;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Set;

public class LottoGame {

    private static long removeChange(long money) {
        final int LOTTO_PRICE = 1000;
        return money / LOTTO_PRICE * LOTTO_PRICE;
    }

    public static void start() {
        long purchaseAmount = removeChange(InputView.inputPurchaseAmount());
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottoList = lottoMachine.buySeveralLotto(purchaseAmount);
        ResultView.printLottoList(lottoList);

        Set<Integer> lastWeekWinningNumbers = InputView.inputLastWeekWinningNumber();
        LottoResult lottoResult = new LottoResult(lastWeekWinningNumbers);
        ResultView.printLottoResult(lottoResult.winningLottoCount(lottoList));
        ResultView.printRateOfReturn(lottoResult.rateOfReturn(purchaseAmount, lottoList));
    }
}
