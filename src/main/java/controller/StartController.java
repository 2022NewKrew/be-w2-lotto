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

    public static void addLottoLines(MyLottoLines lottoLines, int numLotto) {
        for (int i = 0; i < numLotto; i++) {
            LottoLine curLotto = new RandomLottoLine();

            lottoLines.addLotto(curLotto);
            OutputView.printLottoLine(curLotto.getPrintLine());
        }
    }

    private static LottoLine inputManualLottoLine() {
        return ManualLottoLine.makeManualLottoLineFromStrLst(InputView.getWinNumber());
    }

    public static WinningLottoLine makeWinningLine() {
        LottoLine lottoLine = inputManualLottoLine();

        while (lottoLine == null) {
            OutputView.printWinningInputError();
            lottoLine = inputManualLottoLine();
        }

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
}
