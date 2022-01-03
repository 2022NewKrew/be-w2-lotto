package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Rewards {
    public static final Map<Integer, Integer> PRIZE = new HashMap<>() {{
        put(3, 5000);
        put(4, 50000);
        put(5, 1500000);
        put(6, 2000000000);
    }};

    private Map<Integer, Integer> matchCounts;

    public Rewards() {
        this.matchCounts = new HashMap<>();
        for (Integer numMatch : PRIZE.keySet()){
            matchCounts.put(numMatch, 0);
        }
    }

    public void addMatch(int numMatch) {
        if (!PRIZE.containsKey(numMatch)){
            return;
        }

        this.matchCounts.put(numMatch, this.matchCounts.get(numMatch) + 1);
    }

    public int getTotalReward() {
        int totalReward = 0;
        for (Integer numMatch : matchCounts.keySet()) {
            totalReward += this.matchCounts.get(numMatch) * PRIZE.get(numMatch);
        }
        return totalReward;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계\n");
        builder.append("---------\n");
        for (Integer numMatch : PRIZE.keySet()) {
            builder.append(numMatch + "개 일치 ");
            builder.append("(");
            builder.append(PRIZE.get(numMatch));
            builder.append(")- ");
            builder.append(matchCounts.get(numMatch));
            builder.append("개\n");
        }
        return builder.toString();
    }

}
