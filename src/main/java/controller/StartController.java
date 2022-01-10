package controller;

import domain.LottoLine;
import domain.LottoLineStructure.ManualLottoLine;
import domain.LottoLineStructure.RandomLottoLine;

import domain.MyLottoLines;
import domain.WinningLottoLine;
import view.InputView;
import view.OutputView;

public class StartController {
    private StartController() {
        throw new AssertionError();
    }

    public static int inputNumLotto() {
        int numLotto = InputView.getNumLotto();
        while (numLotto == 0) {
            OutputView.printPayInputError();
            numLotto = InputView.getNumLotto();
        }

        return numLotto;
    }

    public static int inputNumManualLotto(int totalNum) {
        int numLotto = InputView.getManualNumLotto();
        while (numLotto < 0 || totalNum < numLotto) {
            OutputView.printManualNumberError(totalNum);
            numLotto = InputView.getManualNumLotto();
        }

        return numLotto;
    }

    public static void addManualLottoLines(MyLottoLines lottoLines, int numLotto) {
        OutputView.announceBeforeManualLine();
        for (int i = 0; i < numLotto; i++) {
            LottoLine curLotto = inputManualLottoLine();

            lottoLines.addLotto(curLotto);
            OutputView.printLottoLine(curLotto.getPrintLine());
        }
    }

    public static void addAutoLottoLines(MyLottoLines lottoLines, int numLotto) {
        for (int i = 0; i < numLotto; i++) {
            LottoLine curLotto = new RandomLottoLine();

            lottoLines.addLotto(curLotto);
            OutputView.printLottoLine(curLotto.getPrintLine());
        }
    }

    private static LottoLine inputManualLottoLine() {
        LottoLine ret = ManualLottoLine.makeManualLottoLineFromStrLst(InputView.getManualNumber());

        if (ret == null) {
            OutputView.printManualInputError();
            ;
            ret = inputManualLottoLine();
        }

        return ret;
    }

    public static WinningLottoLine makeWinningLine() {
        OutputView.announceBeforeWinningLine();
        LottoLine lottoLine = inputManualLottoLine();

        WinningLottoLine winningLottoLine = new WinningLottoLine(lottoLine);
        setBonus(winningLottoLine);

        return winningLottoLine;
    }

    private static void setBonus(WinningLottoLine winningLine) {
        boolean isValid = winningLine.setBonus(InputView.getBonus());
        while (!isValid) {
            OutputView.printBonusInputError();
            isValid = winningLine.setBonus(InputView.getBonus());
        }
    }

    public static void printPurchaseSummary(int numManLotto, int numAutoLotto) {
        OutputView.printAutoManualNum(numAutoLotto, numManLotto);
    }
}
