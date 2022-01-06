package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LottoGame {
    public void run() {

        int purchasedAmount = InputView.purchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        LottoEmployee lottoEmployee = new LottoEmployee();
        LottoRepository autoLottos = lottoMachine.createAutoLottos(lottoEmployee.buyLottos(purchasedAmount));

        OutputView.printAutoLottos(autoLottos);
        LottoWinningNumber inputLastWeekWinNumber = InputView.bonusNumber();

        LottoRankMatch lottoRankMatch = LottoRankMatch.createResult(autoLottos, inputLastWeekWinNumber);
        OutputView.printProfit(lottoRankMatch, lottoEmployee.getProfitRate(lottoRankMatch, purchasedAmount));

    }
}
