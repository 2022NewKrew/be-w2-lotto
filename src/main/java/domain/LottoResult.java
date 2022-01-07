package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final WinningLotto winningLotto;
    private final List<Lotto> userLottoList;
    private final Map<MatchStatus, Integer> matchingResult = new EnumMap<>(MatchStatus.class);

    public LottoResult(WinningLotto winningLotto, List<Lotto> userLottoList) {
        this.winningLotto = winningLotto;
        this.userLottoList = userLottoList;
        calculateMatchingResult();
    }

    private void calculateMatchingResult() {
        for (var e: MatchStatus.values()) {
            matchingResult.put(e, 0);
        }
        for (Lotto lotto: userLottoList) {
            int matchCount = winningLotto.checkNumberOfWinning(lotto);
            boolean isBonusMatched = winningLotto.checkBonusBallMatched(lotto);
            reflectScore(matchCount, isBonusMatched);
        }
    }

    public int getCountByMatchResult(MatchStatus status) {
        return matchingResult.get(status);
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
