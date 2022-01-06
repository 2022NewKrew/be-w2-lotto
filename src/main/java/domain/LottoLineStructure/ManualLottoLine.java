package domain.LottoLineStructure;

import domain.LottoLine;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoLine implements LottoLine {
    public List<Integer> lottoLine;

    public ManualLottoLine(List<Integer> paramLottoLine) {
        lottoLine = paramLottoLine;
    }

    public int checkWinning(List<Integer> winningNumbers) {
        int matchNum = 0;

        for (int num : winningNumbers) {
            matchNum += lottoLine.contains(num) ? 1 : 0;
        }

        return matchNum;
    }

    public List<Integer> getLottoLine() {
        return new ArrayList<>(lottoLine);
    }

    public String getPrintLine() {
        return lottoLine.toString();
    }
}
