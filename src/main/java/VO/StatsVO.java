package VO;

import domain.Rank;

import java.util.Map;

public class StatsVO {
    Map<Rank, Integer> stats;
    long totalPrizeMoney;

    public StatsVO(Map<Rank, Integer> stats, long totalPrizeMoney) {
        this.stats = stats;
        this.totalPrizeMoney = totalPrizeMoney;
    }

    public Map<Rank, Integer> getStats() {
        return stats;
    }

    public long getTotalPrizeMoney() {
        return totalPrizeMoney;
    }
}
