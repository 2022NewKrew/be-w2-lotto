package domain;

import java.util.Map;

public class Result {
    Map<Rank, Integer> results;

    public Result(Map<Rank, Integer> results) {
        this.results = results;
    }

    public Integer get(Rank index) {
        return results.get(index);
    }

    public long getProfit(int totalPrice) {
        long totalRewards = 0;

        for (Rank rank : results.keySet()) {
            int count = results.get(rank);
            totalRewards += (long) count * rank.getWinningMoney();
        }

        return ((totalRewards - totalPrice) * 100) / (totalPrice);
    }
}

