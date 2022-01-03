package controller;

import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoRepository;
import service.LottoGameService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoGame {
    public void run() {
        int purchasedLottoNumbers = InputView.inputPurchaseAmount();

        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoRepository autuLottos = lottoGenerator.createAutoLottos(purchasedLottoNumbers);

        OutputView.printAutuLottos(autuLottos);
        List<Integer> inputLastWeekWinNumber = InputView.inputLastWeekWinNumber();

        LottoGameService.createResult(autuLottos, inputLastWeekWinNumber);

    }
}
