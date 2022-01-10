package lottogame.dto;

import lottogame.domain.Rank;
import lottogame.domain.Ranks;

import java.util.HashMap;

public class Mapper {

    private Mapper() {
    }

    public static Statistics makeStatistics(Ranks ranks) {
        HashMap<Rank, Integer> statistics = new HashMap<>();
        for (var rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (var rank : ranks.getRanks()) {
            statistics.computeIfPresent(rank, (key, value) -> value + 1);
        }
        return new Statistics(statistics);
    }
}
