package com.kakao.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2000000000, "1등"),
    SECOND(5, 30000000, "2등"),
    THRID(5, 1500000, "3등"),
    FOURTH(4, 50000, "4등"),
    FIFTH(3, 5000, "5등");

    private final int countOfMatch;
    private final int winningMoney;
    private final String explanation;

    public int getCountOfMatch() { return countOfMatch; }

    public int getWinningMoney() { return winningMoney; }

    public String getExplanation() { return explanation; }

    Rank(int countOfMatch, int winningMoney, String explanation) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.explanation = explanation;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        List<Rank> ranks = Arrays.asList(values());
        return ranks.stream()
                .filter(rank -> filterRank(rank, countOfMatch, matchBonus))
                .findFirst()
                .orElse(null);
    }

    private static boolean filterRank(Rank rank, int countOfMatch, boolean matchBonus) {
        boolean match = rank.countOfMatch == countOfMatch;
        if (rank == SECOND) {
            return matchBonus && match;
        }
        return match;
    }
}
