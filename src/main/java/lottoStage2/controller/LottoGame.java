package lottoStage2.controller;

import lottoStage2.domain.lotto.Lotto;
import lottoStage2.domain.lotto.Lottos;
import lottoStage2.domain.winning.WinningResult;
import lottoStage2.view.InputView;
import lottoStage2.view.ResultView;

public class LottoGame {

    public static void run() {
        int price = InputView.inputPrice();
        Lottos lottos = Lottos.purchase(price);

        ResultView.showLottoCount(lottos);
        ResultView.showAllLottoNumbers(lottos);
        System.out.println();

        String winningNumbers = InputView.inputLastWeekLottoNumber();
        Lotto winningLotto = Lotto.of(winningNumbers.split(", "));

        int bonusNumber = InputView.inputBonusNumber();

        WinningResult winningResult = lottos.getWinningResult(winningLotto, bonusNumber);
        System.out.println();

        ResultView.showStatistics(price, winningResult);
    }
}
