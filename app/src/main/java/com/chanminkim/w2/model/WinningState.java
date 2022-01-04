package com.chanminkim.w2.model;

public enum WinningState {
    FIRST_PRIZE(Lotto.LOTTO_NUMBERS_LENGTH_LIMIT, 2_000_000_000, false),
    SECOND_PRIZE(Lotto.LOTTO_NUMBERS_LENGTH_LIMIT - 1, 3_000_000, true),
    THIRD_PRIZE(Lotto.LOTTO_NUMBERS_LENGTH_LIMIT - 1, 1_500_000, false),
    FORTH_PRIZE(Lotto.LOTTO_NUMBERS_LENGTH_LIMIT - 2, 50_000, false),
    FIFTH_PRIZE(Lotto.LOTTO_NUMBERS_LENGTH_LIMIT - 3, 5_000, false);

    private final int matchedCount;
    private final int prizeMoney;
    private final boolean isCountingBonus;

    WinningState(int matchedCount, int prizeMoney, boolean isCountingBonus) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
        this.isCountingBonus = isCountingBonus;
    }

    public static WinningState findByMatchedCountAndBonus(int matchedCount, boolean isContainingBonus) {
        for (WinningState value : values()) {
            if (value.matchedCount == matchedCount
                    && value.isCountingBonus == isContainingBonus) {
                return value;
            }
        }
        return null;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isCountingBonus() {
        return isCountingBonus;
    }
}
