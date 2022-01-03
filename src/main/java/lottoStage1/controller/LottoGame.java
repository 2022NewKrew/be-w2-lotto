package lottoStage1.controller;

import lottoStage1.domain.Lottos;
import lottoStage1.domain.WinningResult;
import lottoStage1.view.InputView;
import lottoStage1.view.ResultView;

public class LottoGame {

    public static void run() {
        int price = InputView.inputPrice();
        Lottos lottos = Lottos.purchase(price);

        ResultView.showLottoCount(lottos);
        ResultView.showAllLottoNumbers(lottos);
        System.out.println();

        String winningNumbers = InputView.inputLastWeekLottoNumber();
        WinningResult winningResult =
        System.out.println();

        ResultView.showStatistics();
    }
}
