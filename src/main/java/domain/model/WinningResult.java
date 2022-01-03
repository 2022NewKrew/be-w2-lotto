package domain.model;

import java.util.Map;

public class WinningResult {

    private final Map<Integer, Integer> countMap;

    private final int profit;

    public WinningResult(Map<Integer, Integer> countMap, int profit) {
        this.countMap = countMap;
        this.profit = profit;
    }

    public Map<Integer, Integer> getCountMap() {
        return countMap;
    }

    public int getProfit() {
        return profit;
    }
}
