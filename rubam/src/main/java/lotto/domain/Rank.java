package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 15000000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int countOfMatch;
    private final int reward;

    Rank(int countOfMatch, int reward) {
        this.countOfMatch = countOfMatch;
        this.reward = reward;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getReward() {
        return reward;
    }

    public static Rank valueOf(int countOfMatch, boolean bonusMatch) {
        List<Rank> ranks = Arrays.asList(values());
        for (Rank rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return bonusMatch ? SECOND : THIRD;
            }

            if (countOfMatch == rank.countOfMatch)
                return rank;
        }
        return null;
    }
}
