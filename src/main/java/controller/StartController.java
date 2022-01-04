package controller;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StartController {
    private final List<List<Integer>> lottoLines = new ArrayList<>();
    private List<Integer> winningLine;

    private static final int NUM_PER_LINE = 6;

    public StartController() {
        makeLottoLines();
        makeWinningLine();
    }

    public List<List<Integer>> getLottoLines() {
        List<List<Integer>> newLottoLine = new ArrayList<>();

        for (List<Integer> lottoLine : lottoLines) {
            newLottoLine.add(new ArrayList<>(lottoLine));
        }

        return newLottoLine;
    }

    public List<Integer> getWinningLine() {
        return new ArrayList<>(winningLine);
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
        List<String> strLine = InputView.getWinNumber();

        while (strLine.size() != 6) {
            System.out.println("1부터 45까지의 숫자 6개를 ','로 나누어서 입력해주세요.");
            strLine = InputView.getWinNumber();
        }

        convert2IntList(strLine);
    }

    private void convert2IntList(List<String> strList) {
        List<Integer> retList = new ArrayList<>();

        for (String str : strList) {
            retList.add(Integer.valueOf(str));
        }

        sortAndVerify(retList);
    }

    private void sortAndVerify(List<Integer> srcList) {
        Collections.sort(srcList);

        if (srcList.get(0) < 1 || srcList.get(5) > 45) {
            System.out.println("1부터 45까지의 숫자 6개를 ','로 나누어서 입력해주세요.");
            makeWinningLine();
            return;
        }

        winningLine = srcList;
    }

    private int findNewNumber(List<Integer> lottoLine) {
        int newNum = (int) (Math.random() * 45) + 1;
        while (lottoLine.contains(newNum)) {
            newNum = (int) (Math.random() * 45) + 1;
        }

        return newNum;
    }
}
