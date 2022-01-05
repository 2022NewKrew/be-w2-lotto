package lotto.model;

import lotto.VO.Rank;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> countsOfRank;

    public LottoResult() {
        this.countsOfRank = new HashMap<>();
        for (Rank rank : Rank.values()) {
            this.countsOfRank.put(rank, 0);
        }
    }

    public void increaseCountOfRank(Rank rank) {
        if (countsOfRank.keySet().contains(rank)) {
            countsOfRank.put(rank, countsOfRank.get(rank) + 1);
        }
    }

    public int getCountOf(Rank rank) {
        if (countsOfRank.keySet().contains(rank)){
            return countsOfRank.get(rank);
        }
        return 0;
    }

}
