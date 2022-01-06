package com.meg.w2lotto.domain;

public enum Prize {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private final int matchCount;
    private final int winningMoney;
    private final boolean isBonus;

    Prize(int matchCount, int winningMoney, boolean isBonus) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.isBonus = isBonus;
    }

    public static final Prize valueOf(int matchCount, boolean isBonus) {
        if (matchCount == SECOND.matchCount) {
            return isBonus ? SECOND : THIRD;
        }
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount) return prize;
        }
        return null;
    }

    public final int getMatchCount() {
        return matchCount;
    }

    public final int getWinningMoney() {
        return  winningMoney;
    }

    public final boolean isBonus() {
        return isBonus;
    }
}
