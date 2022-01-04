package controller;

import model.Lotto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    public LottoController() {
    }

    public void run() {
        int purchaseAmount = InputView.readPurchaseAmount();
        List<Lotto> lottos = LottoGenerator.createAutoLotto(purchaseAmount / 1000);
        OutputView.printLottos(lottos);

        List<Integer> lastWeeksWinningNumber = InputView.readLastWeeksWinningNumber();
        int bonusNumber = InputView.readBonusNumber();

        List<Integer> rankResults = LottoHandler.getRankResults(lastWeeksWinningNumber, bonusNumber, lottos);
        long totalWinningAmount = LottoHandler.getTotalWinningAmount(rankResults);

        // 당첨 통계 출력
        OutputView.printLottoWinningStats(rankResults, totalWinningAmount, lottos.size());
    }
}