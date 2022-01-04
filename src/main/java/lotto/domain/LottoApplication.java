package lotto.domain;

import lotto.view.LottoScanner;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 6:04
 */
public class LottoApplication {

    public static void start() {
        Integer purchaseAmount = LottoScanner.getPurchaseAmount();
        Integer lottoAmount = purchaseAmount / Constants.LOTTO_PRICE;
        Integer bonusBall = LottoScanner.getBonusBall();

        LottoBundle lottoBundle = new LottoBundle(lottoAmount, bonusBall);
        lottoBundle.printLottos();

        LottoGame lottoGame = new LottoGame(lottoBundle);
        lottoGame.playLottoGame();
        lottoGame.printStatistics(purchaseAmount);
    }

}
