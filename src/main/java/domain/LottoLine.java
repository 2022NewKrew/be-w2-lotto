package domain;

import DTO.nNumber;

import java.util.List;

public class LottoLine {
    public List<Integer> lottoLine;

    public LottoLine(nNumber paramLottoLine) {
        lottoLine = paramLottoLine.getNumbers();
    }

    public int checkWinning(nNumber winningNumbers) {
        List<Integer> winningLine = winningNumbers.getNumbers();
        int matchNum = 0;

        for (int num : winningLine) {
            matchNum += lottoLine.contains(num) ? 1 : 0;
        }

        return matchNum;
    }
}
