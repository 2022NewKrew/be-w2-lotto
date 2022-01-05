package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LottoGame {
    public void run() {

        int purchasedAmount = InputView.purchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        LottoRepository autoLottos = lottoMachine.createAutoLottos(LottoCashier.buyLottos(purchasedAmount));

        OutputView.printAutoLottos(autoLottos);
        LottoBonus inputLastWeekWinNumber = InputView.bonusNumber();
//        Integer bonusNumber = InputView.bonusNumber();

        Map<LottoRank, Integer> lottoRankResult = LottoRankMatch.createResult(autoLottos, inputLastWeekWinNumber);

        OutputView.printProfit(lottoRankResult, purchasedAmount);

    }
}
