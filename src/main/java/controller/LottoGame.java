package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGame {
    public void run() {
        int purchasedAmount = InputView.purchaseAmount();
        int purchasedLottoNumbers = purchasedAmount / 1000;

        LottoMachine lottoMachine = new LottoMachine();
        LottoRepository autoLottos = lottoMachine.createAutoLottos(purchasedLottoNumbers);

        OutputView.printAutoLottos(autoLottos);
        List<Integer> inputLastWeekWinNumber = InputView.numbers();

        Map<LottoRank, Integer> lottoRankResult = LottoRankMatch.createResult(autoLottos, inputLastWeekWinNumber);
        System.out.println(lottoRankResult);

        OutputView.printProfit(lottoRankResult, purchasedAmount);
//        Double a = LottoProfitRate.createProfitRate(lottoRankResult, purchasedAmount);

    }
}
