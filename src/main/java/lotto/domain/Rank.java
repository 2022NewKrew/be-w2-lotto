package lotto.domain;

import java.util.List;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 15000000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int countOfMatch;
    private final boolean isBonusMatched;
    private final int reward;

    Rank(int countOfMatch, boolean isBonusMatched, int reward) {
        this.countOfMatch = countOfMatch;
        this.isBonusMatched = isBonusMatched;
        this.reward = reward;
    }

    public static Rank valueOf(int countOfMatch, boolean isBonus) {
        List<Rank> ranks = List.of(values());
        for (Rank rank : ranks) {
            if (rank.countOfMatch == countOfMatch && rank.isBonusMatched == isBonus)
                return rank;
        }
        return NONE;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getReward() {
        return reward;
    }
}
