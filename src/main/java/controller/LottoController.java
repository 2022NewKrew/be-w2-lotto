package main.java.controller;

import main.java.model.Lotto;
import main.java.view.InputView;
import main.java.view.OutputView;

import java.util.List;

public class LottoController {
    public LottoController() {
    }

    public void run() {
        int purchaseAmount = InputView.readPurchaseAmount();
        List<Lotto> lottos = LottoGenerator.createAutoLotto(purchaseAmount / 1000);
        OutputView.printLottos(lottos);

        List<Integer> lastWeeksWinningNumber = InputView.readLastWeeksWinningNumber();
        OutputView.printLottoWinningStats(lastWeeksWinningNumber, lottos);
    }
}