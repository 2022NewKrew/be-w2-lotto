package lottogame.dto;

import lottogame.domain.Rank;

import java.util.HashMap;

public class Statistics {
    private HashMap<Rank, Integer> statistics;

    public Statistics(HashMap<Rank, Integer> statistics) {
        this.statistics = statistics;
    }

    public HashMap<Rank, Integer> getStatistics() {
        return statistics;
    }
}