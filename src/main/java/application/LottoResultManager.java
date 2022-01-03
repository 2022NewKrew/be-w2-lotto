package application;

import domain.Lotto;
import domain.MatchResult;
import domain.WinningLotto;

import java.util.List;

public class LottoResultManager {
    private static final int MIN_MATCH_NUM_FOR_WINNING = 3;
    private final WinningLotto winningLotto;
    private final List<Lotto> userLottoList;
    private final MatchResult matchResult;

    public LottoResultManager(WinningLotto winningLotto, List<Lotto> userLottoList) {
        this.winningLotto = winningLotto;
        this.userLottoList = userLottoList;
        this.matchResult = new MatchResult();
    }

    public MatchResult getResult() {
        for (Lotto lotto: userLottoList) {
            int matchCount = winningLotto.compareTo(lotto);
            reflectResult(matchCount);
        }
        return matchResult;
    }

    private void reflectResult(int matchCount) {
        if (matchCount >= MIN_MATCH_NUM_FOR_WINNING) {
            matchResult.increase(matchCount);
        }
    }
}
