package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LottoGame {
    public void run() {

        int purchasedAmount = InputView.purchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        LottoRepository autoLottos = lottoMachine.createAutoLottos(LottoEmployee.buyLottos(purchasedAmount));

        OutputView.printAutoLottos(autoLottos);
        LottoWinningNumber inputLastWeekWinNumber = InputView.bonusNumber();

        LottoRankMatch lottoRankMatch = LottoRankMatch.createResult(autoLottos, inputLastWeekWinNumber);

        OutputView.printProfit(lottoRankResult, purchasedAmount);

    }
}
