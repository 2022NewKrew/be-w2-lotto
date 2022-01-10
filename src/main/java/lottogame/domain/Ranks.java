package lottogame.domain;

import java.util.List;

public class Ranks {
    private List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int sumPrizeMoney() {
        int sum = 0;
        for (var rank : ranks) {
            sum += rank.calculatePrizeMoney(1);
        }
        return sum;
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
