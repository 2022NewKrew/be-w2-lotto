package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final long baseMoney;
    private final Map<Rank, Integer> resultMap;

    public Result(long baseMoney) {
        this.baseMoney = baseMoney;
        this.resultMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            this.resultMap.put(rank, 0);
        }
    }

    public void add(List<Rank> ranks) {
        for (Rank rank : ranks) {
            this.add(rank);
        }
    }

    public void add(Rank rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public int getCountOf(Rank rank) {
        return resultMap.get(rank);
    }

    public long getYieldPercent() {
        return 100 * getTotalPrize() / baseMoney;
    }

    private long getTotalPrize() {
        long prize = 0;
        for (Rank rank : resultMap.keySet()) {
            prize += (rank.getPrize() * resultMap.get(rank));
        }
        return prize;
    }
}
