package controller;

import domain.LottoGenerator;
import domain.LottoRank;
import domain.LottoRankMatch;
import domain.LottoRepository;
import service.LottoGameService;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGame {
    public void run() {
        int purchasedLottoNumbers = InputView.inputPurchaseAmount();

        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoRepository autoLottos = lottoGenerator.createAutoLottos(purchasedLottoNumbers);

        OutputView.printAutuLottos(autoLottos);
        List<Integer> inputLastWeekWinNumber = InputView.inputLastWeekWinNumber();

        Map<LottoRank, Integer> = LottoRankMatch.createLottoRankResult(autoLottos, inputLastWeekWinNumber);
//        LottoGameService.createResult(autoLottos, inputLastWeekWinNumber);

    }
}
