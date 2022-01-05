package lotto;

import lotto.controller.LottoController;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.purchaseLottoBundleInView();
        lottoController.printLottoBundle();
        lottoController.getLastWeekLottoNumberList();
        lottoController.getBonusBall();
        lottoController.constructWinningStats();
        lottoController.printWinningStats();
    }
}
