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
        if (baseMoney == 0) {
            throw new IllegalArgumentException("구입 금액 정보가 올바르지 않습니다.");
        }

        if (winningLottery == null) {
            throw new IllegalArgumentException("당첨 복권 정보가 올바르지 않습니다.");
        }

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
        return new Result(resultMap, ((float) (100 * (prize - baseMoney))) / baseMoney);
    }

    public int getCountOf(Rank rank) {
        return resultMap.get(rank);
    }

    public float getYieldPercent() {
        return this.yieldPercent;
    }
}
