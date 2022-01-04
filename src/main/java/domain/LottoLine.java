package domain;

import java.util.List;

public class LottoLine {
    public List<Integer> lottoLine;

    public LottoLine(nNumber paramLottoLine) {
        lottoLine = paramLottoLine.getNumbers();
    }

    public int checkWinning(List<Integer> winningLine) {
        int matchNum = 0;

        for (int num : winningLine) {
            matchNum += lottoLine.contains(num) ? 1 : 0;
        }

        return matchNum;
    }
}
