package controller;

import domain.WinningLottoLine;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StartController {
    private final List<List<Integer>> lottoLines = new ArrayList<>();
    private WinningLottoLine winningLine = null;

    private final int NUM_PER_LINE = 6;

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
            lottoLines.add(makeLottoLine());
            OutputView.printLottoLine(lottoLines.get((i)));
        }
    }

    private List<Integer> makeLottoLine() {
        List<Integer> lottoLst = new ArrayList<>();

        for (int i = 0; i < NUM_PER_LINE; i++) {
            lottoLst.add(findNewNumber(lottoLst));
        }

        Collections.sort(lottoLst);
        return lottoLst;
    }

    private void makeWinningLine() {
        winningLine = null;
        List<String> strLine = InputView.getWinNumber();

        if (strLine.size() != 6) {
            return;
        }

        winningLine = WinningLottoLine.makeWinningLine(strLine);
    }

    private int findNewNumber(List<Integer> lottoLine) {
        int newNum = (int) (Math.random() * 45) + 1;
        while (lottoLine.contains(newNum)) {
            newNum = (int) (Math.random() * 45) + 1;
        }

        return newNum;
    }
}
