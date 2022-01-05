package application;

import domain.Lotto;
import domain.MatchingStatus;
import domain.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultManager {
    private final WinningLotto winningLotto;
    private final List<Lotto> userLottoList;
    private final Map<MatchingStatus, Integer> matchingResult;

    public LottoResultManager(WinningLotto winningLotto, List<Lotto> userLottoList) {
        this.winningLotto = winningLotto;
        this.userLottoList = userLottoList;
        this.matchingResult = new EnumMap<>(MatchingStatus.class);
        for (var e: MatchingStatus.values()) {
            matchingResult.put(e, 0);
        }
    }

    public Map<MatchingStatus, Integer> getMatchingResult() {
        for (Lotto lotto: userLottoList) {
            int matchCount = winningLotto.checkNumberOfWinning(lotto);
            reflectScore(matchCount, false);
        }
        return matchingResult;
    }

    private void reflectScore(int matchCount, boolean isBonusMatched) {
        MatchingStatus status = MatchingStatus.getMatchingStatus(matchCount, false);
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
