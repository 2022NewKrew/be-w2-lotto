package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoGame {
    public void run() {

        int purchasedAmount = InputView.purchaseAmount();
        int manualQuantity = InputView.purchaseManualLNumber();

        LottoMachine lottoMachine = new LottoMachine();
        LottoBank lottoBank = new LottoBank();
        List<Lotto> autoLottos = lottoMachine.createAutoLottos(lottoBank.buyLottos(purchasedAmount, manualQuantity));
        List<Lotto> manualLottos = lottoMachine.createManualLottos(manualQuantity);

        OutputView.printAutoLottos(autoLottos);
        LottoWinningNumber inputLastWeekWinNumber = InputView.bonusNumber();

        LottoRankMatch lottoRankMatch = LottoRankMatch.createResult(autoLottos, inputLastWeekWinNumber);
        OutputView.printProfit(lottoRankMatch, lottoBank.getProfitRate(lottoRankMatch, purchasedAmount));

    }
}
