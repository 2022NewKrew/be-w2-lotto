package application;

import domain.Lotto;
import domain.MatchStatus;
import domain.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultManager {
    private final WinningLotto winningLotto;
    private final List<Lotto> userLottoList;
    private final Map<MatchStatus, Integer> matchingResult;

    public LottoResultManager(WinningLotto winningLotto, List<Lotto> userLottoList) {
        this.winningLotto = winningLotto;
        this.userLottoList = userLottoList;
        this.matchingResult = new EnumMap<>(MatchStatus.class);
        for (var e: MatchStatus.values()) {
            matchingResult.put(e, 0);
        }
    }

    public Map<MatchStatus, Integer> getMatchingResult() {
        for (Lotto lotto: userLottoList) {
            int matchCount = winningLotto.checkNumberOfWinning(lotto);
            boolean isBonusMatched = winningLotto.checkBonusBallMatched(lotto);
            reflectScore(matchCount, isBonusMatched);
        }
        return matchingResult;
    }

    private void reflectScore(int matchCount, boolean isBonusMatched) {
        MatchStatus status = MatchStatus.getMatchingStatus(matchCount, isBonusMatched);
        matchingResult.put(status, matchingResult.get(status) + 1);
    }

    public Long getTotalPrizeMoney() {
        long totalPrizeMoney = 0;
        for (var e: matchingResult.entrySet()) {
            totalPrizeMoney += (long) e.getKey().getPrizeMoney() * e.getValue();
        }
        return totalPrizeMoney;
    }
}
