package lottoStage2.controller;

import lottoStage2.domain.Lotto;
import lottoStage2.domain.Lottos;
import lottoStage2.domain.WinningResult;
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
        WinningResult winningResult = lottos.getWinningResult(winningLotto);
        System.out.println();

        ResultView.showStatistics(price, winningResult);
    }
}
