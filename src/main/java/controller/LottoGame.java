package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LottoGame {
    public void run() {

        int purchasedAmount = InputView.purchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        LottoCashier lottoCashier = new LottoCashier();
        LottoRepository autoLottos = lottoMachine.createAutoLottos(lottoCashier.buyLottos(purchasedAmount));

        OutputView.printAutoLottos(autoLottos);
        LottoWinningNumber inputLastWeekWinNumber = InputView.bonusNumber();

        LottoRankMatch lottoRankMatch = LottoRankMatch.createResult(autoLottos, inputLastWeekWinNumber);
        OutputView.printProfit(lottoRankMatch, lottoCashier.getProfitRate(lottoRankMatch, purchasedAmount));

    }
}
