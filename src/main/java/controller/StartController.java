package controller;

import DTO.nNumber;
import domain.MyLottoLines;
import domain.WinningLottoLine;
import view.InputView;
import view.OutputView;

import java.util.List;

public class StartController {
    private final MyLottoLines lottoLines = new MyLottoLines();
    private WinningLottoLine winningLine = null;

    public StartController() {
        makeLottoLines();
        makeWinningLine();
        while (winningLine == null) {
            OutputView.printWinningInputError();
            makeWinningLine();
        }
    }

    public MyLottoLines getLottoLines() {
        return lottoLines;
    }

    public nNumber getWinningLine() {
        return nNumber.makeManualNumbers(winningLine.getLottoLine());
    }

    private void makeLottoLines() {
        int numLotto = InputView.getNumLotto();
        while (numLotto < 1) {
            numLotto = InputView.getNumLotto();
        }

        for (int i = 0; i < numLotto; i++) {
            nNumber curLine = nNumber.makeRandomNumbers();

            lottoLines.addLotto(curLine);
            OutputView.printLottoLine(curLine);
        }
    }

    private void makeWinningLine() {
        winningLine = null;
        List<String> strLine = InputView.getWinNumber();

        if (strLine.size() != 6) {
            return;
        }

        winningLine = WinningLottoLine.makeWinningLine(strLine);
    }
}
