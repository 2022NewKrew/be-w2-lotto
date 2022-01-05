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
        int purchasedLottoNumbers = InputView.purchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        LottoRepository autoLottos = lottoMachine.createAutoLottos(purchasedLottoNumbers);

        OutputView.printAutoLottos(autoLottos);
        List<Integer> inputLastWeekWinNumber = InputView.numbers();

        Map<LottoRank, Integer> lottoRankResult = LottoRankMatch.createResult(autoLottos, inputLastWeekWinNumber);
        System.out.println(lottoRankResult);

    }
}
