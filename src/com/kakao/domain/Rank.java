package com.kakao.domain;

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
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THRID;
            }

            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }

        return null;
    }
}
