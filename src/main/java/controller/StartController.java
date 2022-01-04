package controller;

import domain.MyLottoLines;
import domain.WinningLottoLine;
import domain.nNumber;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
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

    public List<Integer> getWinningLine() {
        return new ArrayList<>(winningLine.getLottoLine());
    }

    private void makeLottoLines() {
        int numLotto = InputView.getNumLotto();
        while (numLotto < 1) {
            numLotto = InputView.getNumLotto();
        }

        for (int i = 0; i < numLotto; i++) {
            nNumber curLine = nNumber.makeRandomNumbers();

            lottoLines.addLotto(curLine);
            OutputView.printLottoLine(curLine.getNumbers());
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
