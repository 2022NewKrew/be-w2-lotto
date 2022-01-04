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
        LottoBundle lottoBundle = createLottoBundle();
        lottoBundle.printLottos();

        List<Integer> lastWeekWinningNumbers = LottoScanner.getLastWeekWinningNumbers();
        Integer bonusBall = LottoScanner.getBonusBall();
        WinningLotto winningLotto = new WinningLotto(lastWeekWinningNumbers, bonusBall);

        LottoGame lottoGame = new LottoGame();
        lottoGame.createLottoResult(lottoBundle, winningLotto);
        lottoGame.printStatistics(lottoBundle);
    }

    public static LottoBundle createLottoBundle() {
        Integer purchaseAmount = LottoScanner.getPurchaseAmount();
        Integer lottoCount = purchaseAmount / Constants.LOTTO_PRICE;
        Integer manualLottoCount = LottoScanner.getManualLottoCount();

        return new LottoBundle(lottoCount, manualLottoCount);
    }
}
