package com.david.lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
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
}
