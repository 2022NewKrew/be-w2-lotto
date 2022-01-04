package controller;

import domain.LottoMachine;
import domain.LottoRank;
import domain.LottoRankMatch;
import domain.LottoRepository;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGame {
    public void run() {
        int purchasedLottoNumbers = InputView.inputPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        LottoRepository autoLottos = lottoMachine.createAutoLottos(purchasedLottoNumbers);

        OutputView.printAutuLottos(autoLottos);
        List<Integer> inputLastWeekWinNumber = InputView.inputLastWeekWinNumber();

        Map<LottoRank, Integer> lottoRankResult = LottoRankMatch.createLottoRankResult(autoLottos, inputLastWeekWinNumber);
        System.out.println(lottoRankResult);

    }
}
