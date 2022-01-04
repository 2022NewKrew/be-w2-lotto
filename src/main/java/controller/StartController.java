package controller;

import domain.WinningLottoLine;
import domain.nNumber;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class StartController {
    private final List<List<Integer>> lottoLines = new ArrayList<>();
    private WinningLottoLine winningLine = null;

    public StartController() {
        makeLottoLines();
        makeWinningLine();
        while (winningLine == null) {
            OutputView.printWinningInputError();
            makeWinningLine();
        }
    }

    public List<List<Integer>> getLottoLines() {
        List<List<Integer>> newLottoLine = new ArrayList<>();

        for (List<Integer> lottoLine : lottoLines) {
            newLottoLine.add(new ArrayList<>(lottoLine));
        }

        return newLottoLine;
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

            lottoLines.add(curLine.getNumbers());
            OutputView.printLottoLine(lottoLines.get(i));
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
