package lottogame.domain;

import java.util.HashMap;

public class Statistics {
    private HashMap<Rank, Integer> statistics;

    public Statistics(HashMap<Rank, Integer> statistics) {
        this.statistics = statistics;
    }

    public HashMap<Rank, Integer> getStatistics() {
        return statistics;
    }

    public int sumPrizeMoney() {
        int sum = 0;
        for (var statisticsSet : statistics.entrySet()) {
            Rank rank = statisticsSet.getKey();
            int count = statisticsSet.getValue();
            sum += rank.calculatePrizeMoney(count);
        }
        return sum;
    }
}
