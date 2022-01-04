package com.kakao.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THRID(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int cntOfMatch;
    private final int winningMoney;

    public int getCntOfMatch() { return cntOfMatch; }

    public int getWinningMoney() { return winningMoney; }

    private Rank(int cntOfMatch, int winningMoney) {
        this.cntOfMatch = cntOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int cntOfMatch) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (rank.cntOfMatch == cntOfMatch) {
                return rank;
            }
        }
        return null;
    }

//    public static Rank valueOf(int cntOfMatch, boolean matchBonus) {
//        Rank[] ranks = values();
//        for (Rank rank : ranks) {
//            if (cntOfMatch == SECOND.cntOfMatch) {
//                return matchBonus ? SECOND : THRID;
//            }
//
//            if (rank.cntOfMatch == cntOfMatch) {
//                return rank;
//            }
//        }
//
//        return null;
//    }
}
