package domain;

import DTO.NNumber;

import java.util.ArrayList;
import java.util.List;

public class MyLottoLines {
    private final List<LottoLine> lottoLines = new ArrayList<>();

    public MyLottoLines() {
    }

    public void addLotto(NNumber numbers) {
        LottoLine curLottoLine = new LottoLine(numbers);
        lottoLines.add(curLottoLine);
    }

    public void checkWinning(NNumber winningNumbers, NNumber bonusNum) {
        for (LottoLine curLottoLine : lottoLines) {
            int matchNum = curLottoLine.checkWinning(winningNumbers);
            int matchBonusNum = curLottoLine.checkWinning(bonusNum);

            MatchScore ms = MatchScore.findMatchScoreObject(matchNum, matchBonusNum);
            ms.addNumLotto();
        }
    }

    public int getNumLotto() {
        return lottoLines.size();
    }
}
