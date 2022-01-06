package domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottoLines {
    private final List<LottoLine> lottoLines = new ArrayList<>();

    public MyLottoLines() {
    }

    public void addLotto(LottoLine lottoLine) {
        lottoLines.add(lottoLine);
    }

    public void checkWinning(List<Integer> winningNumbers, List<Integer> bonusNum) {
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
