package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LottoGame {
    public void run() {

        int purchasedAmount = InputView.purchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        LottoRepository autoLottos = lottoMachine.createAutoLottos(LottoEmployee.buyLottos(purchasedAmount));

        OutputView.printAutoLottos(autoLottos);
        LottoWinningNumber inputLastWeekWinNumber = InputView.bonusNumber();

        LottoRankMatch lottoRankMatch = LottoRankMatch.createResult(autoLottos, inputLastWeekWinNumber);
        System.out.println(lottoRankMatch);
        System.out.println(lottoRankMatch.getLottoResult());

//        OutputView.printProfit(lottoRankResult, purchasedAmount);

    }
}
