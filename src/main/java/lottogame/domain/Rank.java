package lottogame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int numberOfMatch;
    private int prizeMoney;

    Rank(int numberOfMatch, int prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(Integer numberOfMatch, boolean bonusMatch) {
        List<Rank> matchRanks = Arrays.asList(values()).stream()
                .filter(rank -> numberOfMatch == rank.numberOfMatch)
                .collect(Collectors.toList());

        if (matchRanks.size() == 1)
            return matchRanks.get(0);

        if (matchRanks.size() == 2)
            return rankByBonusMatch(bonusMatch);

        return null;
    }

    private static Rank rankByBonusMatch(boolean bonusMatch) {
        if (bonusMatch)
            return SECOND;
        return THIRD;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int calculatePrizeMoney(int count) {
        return prizeMoney * count;
    }
}
