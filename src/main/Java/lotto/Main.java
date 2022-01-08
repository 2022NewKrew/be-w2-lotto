package lotto;

import lotto.controller.LottoController;
import lotto.domain.winningstats.lottobundle.LottoBundle;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.printWinningStats(
                lottoController.constructWinningStats(
                        lottoController.purchaseLottoBundleInView()
                )
        );
    }
}
