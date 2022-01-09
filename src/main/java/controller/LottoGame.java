package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Set;

public class LottoGame {
    public void run() {

        int purchasedAmount = InputView.purchaseAmount();
        int manualQuantity = InputView.purchaseManualLNumber();

        LottoMachine lottoMachine = new LottoMachine();
        LottoBank lottoBank = new LottoBank();
        List<Lotto> autoLottos = lottoMachine.createAutoLottos(lottoBank.buyLottos(purchasedAmount, manualQuantity));
        List<Lotto> manualLottos = InputView.manualNumbers(manualQuantity);
        LottoRepository lottoRepository = lottoMachine.getAllLottos(autoLottos, manualLottos);

        OutputView.printAllLottos(lottoRepository, manualQuantity);
        LottoWinningNumber inputLastWeekWinNumber = InputView.bonusNumber();

        LottoYield lottoYield = new LottoYield();
        LottoRankMatch lottoRankMatch = LottoRankMatch.createResult(lottoRepository, inputLastWeekWinNumber);
        OutputView.printProfit(lottoRankMatch, lottoYield.getProfitRate(lottoRankMatch, purchasedAmount));
    }
}
