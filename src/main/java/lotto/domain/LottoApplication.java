package lotto.domain;

import lotto.view.LottoScanner;

import java.util.List;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 6:04
 */
public class LottoApplication {

    public static void start() {
        int purchaseAmount = LottoScanner.getPurchaseAmount();
        int manualLottoCount = LottoScanner.getManualLottoCount();
        LottoBundle lottoBundle = new LottoBundle(purchaseAmount, manualLottoCount);
        lottoBundle.printLottos();

        List<Integer> lastWeekWinningNumbers = LottoScanner.getLastWeekWinningNumbers();
        int bonusBall = LottoScanner.getBonusBall();
        WinningLotto winningLotto = new WinningLotto(lastWeekWinningNumbers, bonusBall);

        LottoGame lottoGame = new LottoGame();
        lottoGame.createLottoResult(lottoBundle, winningLotto);
        lottoGame.printStatistics(lottoBundle);
    }
}
