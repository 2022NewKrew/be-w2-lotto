package domain;

import java.util.List;

public class LottoLine {
    public static List<Integer> lottoLine;

    public LottoLine(List<Integer> paramLottoLine) {
        lottoLine = paramLottoLine;
    }

    public int checkWinning(List<Integer> winningLine) {
        int matchNum = 0;

        for (int num : winningLine) {
            matchNum += lottoLine.contains(num) ? 1 : 0;
        }

        return matchNum;
    }
}
