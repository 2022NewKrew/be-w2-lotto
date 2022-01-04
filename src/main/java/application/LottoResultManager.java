package application;

import domain.Lotto;
import domain.MatchScore;
import domain.WinningLotto;

import java.util.List;

public class LottoResultManager {
    private static final int MIN_MATCH_NUM_FOR_WINNING = 3;
    private final WinningLotto winningLotto;
    private final List<Lotto> userLottoList;
    private final MatchScore matchScore;

    public LottoResultManager(WinningLotto winningLotto, List<Lotto> userLottoList) {
        this.winningLotto = winningLotto;
        this.userLottoList = userLottoList;
        this.matchScore = new MatchScore();
    }

    public MatchScore getScore() {
        for (Lotto lotto: userLottoList) {
            int matchCount = winningLotto.checkNumberOfWinning(lotto);
            reflectScore(matchCount);
        }
        return matchScore;
    }

    private void reflectScore(int matchCount) {
        if (matchCount >= MIN_MATCH_NUM_FOR_WINNING) {
            matchScore.increase(matchCount);
        }
    }
}
