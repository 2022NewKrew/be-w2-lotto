package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLottoLines {
    private final List<LottoLine> lottoLines = new ArrayList<>();

    private static final int NUM_PER_LINE = 6;

    public MyLottoLines(List<List<Integer>> paramLottoLines) {
        for (List<Integer> paramLottoLine : paramLottoLines) {
            LottoLine curLottoLine = new LottoLine(paramLottoLine);
            lottoLines.add(curLottoLine);
        }
    }

    public List<Integer> checkWinning(List<Integer> winningLine) {
        List<Integer> matchingLst = new ArrayList<>(Collections.nCopies(NUM_PER_LINE + 1, 0));

        for (LottoLine curLottoLine : lottoLines) {
            int matchNum = curLottoLine.checkWinning(winningLine);
            matchingLst.set(matchNum, matchingLst.get(matchNum) + 1);
        }

        return matchingLst;
    }

    public int getNumOfLotto() {
        return lottoLines.size();
    }
}
