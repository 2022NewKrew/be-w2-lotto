package controller;

import domain.Lotto;
import domain.LottoGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoGame {
    public void run() {
        int purchasedLottoNumbers = InputView.inputPurchaseAmount();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> autuLottos = lottoGenerator.createAutoLottos(purchasedLottoNumbers);

        OutputView.printAutuLottos(autuLottos);
        List<Integer> inputLastWeekWinNumber = InputView.inputLastWeekWinNumber();
        System.out.println(inputLastWeekWinNumber);

    }
}
