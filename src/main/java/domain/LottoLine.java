package domain;

import DTO.NNumber;

import java.util.List;

public class LottoLine {
    public List<Integer> lottoLine;

    public LottoLine(NNumber paramLottoLine) {
        lottoLine = paramLottoLine.getNumbers();
    }

    public int checkWinning(NNumber winningNumbers) {
        List<Integer> winningLine = winningNumbers.getNumbers();
        int matchNum = 0;

        for (int num : winningLine) {
            matchNum += lottoLine.contains(num) ? 1 : 0;
        }

        return matchNum;
    }
}
