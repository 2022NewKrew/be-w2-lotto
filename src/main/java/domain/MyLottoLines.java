package domain;

import DTO.nNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLottoLines {
    private final List<LottoLine> lottoLines = new ArrayList<>();

    private static final int NUM_PER_LINE = 6;

    public MyLottoLines() {
    }

    public void addLotto(nNumber numbers) {
        LottoLine curLottoLine = new LottoLine(numbers);
        lottoLines.add(curLottoLine);
    }

    public List<Integer> checkWinning(nNumber winningNumbers) {
        List<Integer> matchingLst = new ArrayList<>(Collections.nCopies(NUM_PER_LINE + 1, 0));

        for (LottoLine curLottoLine : lottoLines) {
            int matchNum = curLottoLine.checkWinning(winningNumbers);
            matchingLst.set(matchNum, matchingLst.get(matchNum) + 1);
        }

        return matchingLst;
    }

    public int getNumOfLotto() {
        return lottoLines.size();
    }
}
