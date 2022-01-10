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
        List<Set<Integer>> manualStrings = InputView.manualNumbers(manualQuantity);
        List<Lotto> manualLottos = lottoMachine.createManualLottos(manualStrings);
        LottoRepository lottoRepository = lottoMachine.getAllLottos(autoLottos, manualLottos);

        OutputView.printAllLottos(lottoRepository, manualQuantity);
        Set<Integer> lastWeekWinNumber = InputView.lastWeekNumbers();
        Integer bonusBallNumber = InputView.bonusNumber();
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lastWeekWinNumber, bonusBallNumber);

        LottoYield lottoYield = new LottoYield();
        LottoRankMatch lottoRankMatch = LottoRankMatch.createResult(lottoRepository, lottoWinningNumber);
        OutputView.printProfit(lottoRankMatch, lottoYield.getProfitRate(lottoRankMatch, purchasedAmount));
    }
}
