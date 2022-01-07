package com.david.lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(1,6, 2000000000),
    SECOND(2,5, 30000000),
    THIRD(3,5, 1500000),
    FOURTH(4,4, 50000),
    FIFTH(5,3, 5000);

    private final int rank;
    private final int countOfMatch;
    private final int winningMoney;

    Rank(int rank, int countOfMatch, int winningMoney) {
        this.rank = rank;
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        return Arrays.stream(ranks)
                .filter(rank -> rankMatch(rank, countOfMatch, matchBonus))
                .findFirst()
                .orElse(null);
    }

    private static boolean rankMatch(Rank rank, int countOfMatch, boolean matchBonus) {
        boolean match = rank.countOfMatch == countOfMatch;
        if (rank == SECOND) {
            return matchBonus && match;
        }
        return match;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getRank() {
        return rank;
    }
}
