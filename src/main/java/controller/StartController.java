package controller;

import DTO.NNumber;
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

        setBonus();
    }

    public MyLottoLines getLottoLines() {
        return lottoLines;
    }

    public NNumber getWinningLine() {
        return NNumber.makeManualNumbers(winningLine.getLottoLine());
    }

    public NNumber getBonus() {
        return NNumber.makeManualNumbers(List.of(winningLine.getBonus()));
    }

    private void makeLottoLines() {
        int numLotto = InputView.getNumLotto();
        while (numLotto == 0) {
            OutputView.printPayInputError();
            numLotto = InputView.getNumLotto();
        }

        for (int i = 0; i < numLotto; i++) {
            NNumber curLine = NNumber.makeRandomNumbers();

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

    private void setBonus() {
        boolean isValid = winningLine.setBonus(InputView.getBonus());
        while (!isValid) {
            OutputView.printBonusInputError();
            isValid = winningLine.setBonus(InputView.getBonus());
        }
    }
}
