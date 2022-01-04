package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Rewards {

    private Map<Rank, Integer> rankCounts;

    public Rewards() {
        this.rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addReward(int numMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(numMatch, matchBonus);

        if (rank != null) {
            this.rankCounts.put(rank, this.rankCounts.get(rank) + 1);
        }
    }

    public int getTotalReward() {
        int totalReward = 0;
        for (Rank rank : rankCounts.keySet()) {
            totalReward += this.rankCounts.get(rank) * rank.getWinningMoney();
        }
        return totalReward;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계\n");
        builder.append("---------\n");
        for (Rank rank : Rank.values()) {
            builder.append(rank.toString());
            builder.append(" - ");
            builder.append(rankCounts.get(rank));
            builder.append("개\n");
        }
        return builder.toString();
    }

}
