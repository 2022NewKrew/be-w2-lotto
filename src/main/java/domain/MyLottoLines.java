package domain;

import DTO.NNumber;

import java.util.ArrayList;
import java.util.List;

public class MyLottoLines {
    private final List<LottoLine> lottoLines = new ArrayList<>();

    public MyLottoLines() {
    }

    public void addLotto(LottoLine lottoLine) {
        lottoLines.add(lottoLine);
    }

    public void checkWinning(MatchStore matchStore, List<Integer> winningNumbers, List<Integer> bonusNum) {
        for (LottoLine curLottoLine : lottoLines) {
            int matchNum = curLottoLine.checkWinning(winningNumbers);
            int matchBonusNum = curLottoLine.checkWinning(bonusNum);

            matchStore.addMatchResult(matchNum, matchBonusNum);
        }
    }
}
