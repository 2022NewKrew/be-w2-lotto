package lotto.domain;

import java.util.Map;

public class Results {

    private final Map<Rank, Integer> rankToCount;

    public Results(Map<Rank, Integer> rankToCount) {
        this.rankToCount = rankToCount;
    }

    public int calculateReward() {
        int totalReward = 0;
        for (Rank rank : rankToCount.keySet()) {
            totalReward += rankToCount.get(rank) * rank.getReward();
        }
        return totalReward;
    }

    // UI 전용
    public Map<Rank, Integer> getRankToCount() {
        return rankToCount;
    }
}
