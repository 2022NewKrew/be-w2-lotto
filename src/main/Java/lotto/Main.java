package lotto;

import lotto.controller.LottoController;
import lotto.domain.lottobundle.LottoBundle;
import lotto.domain.WinningStats;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.List;

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
