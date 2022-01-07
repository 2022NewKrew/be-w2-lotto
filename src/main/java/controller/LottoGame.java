package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LottoGame {
    public void run() {

        int purchasedAmount = InputView.purchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        LottoBank lottoBank = new LottoBank();
        LottoRepository autoLottos = lottoMachine.createAutoLottos(lottoBank.buyLottos(purchasedAmount));

        OutputView.printAutoLottos(autoLottos);
        LottoWinningNumber inputLastWeekWinNumber = InputView.bonusNumber();

        LottoRankMatch lottoRankMatch = LottoRankMatch.createResult(autoLottos, inputLastWeekWinNumber);
        OutputView.printProfit(lottoRankMatch, lottoBank.getProfitRate(lottoRankMatch, purchasedAmount));

    }
}
