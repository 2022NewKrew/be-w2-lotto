package domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> resultMap;
    private final float yieldPercent;

    private Result(Map<Rank, Integer> resultMap, float yieldPercent) {
        this.resultMap = Collections.unmodifiableMap(resultMap);
        this.yieldPercent = yieldPercent;
    }

    public static Result of(long baseMoney, List<Lottery> lotteries, WinningLottery winningLottery) {
        Map<Rank, Integer> resultMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
        for (Rank rank : winningLottery.checkRank(lotteries)) {
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
        long prize = 0;
        for (Rank rank : resultMap.keySet()) {
            prize += (rank.getPrize() * resultMap.get(rank));
        }
        return new Result(resultMap, 100.0f * (prize - baseMoney) / baseMoney);
    }

    public int getCountOf(Rank rank) {
        return resultMap.get(rank);
    }

    public float getYieldPercent() {
        return this.yieldPercent;
    }
}
