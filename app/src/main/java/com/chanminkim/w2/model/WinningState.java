package com.chanminkim.w2.model;

import com.google.common.collect.Range;

public enum WinningState {
    FIRST_PRIZE(Range.singleton(Lotto.NUMBERS_LENGTH), 2_000_000_000, false),
    SECOND_PRIZE(Range.singleton(Lotto.NUMBERS_LENGTH - 1), 3_000_000, true),
    THIRD_PRIZE(Range.singleton(Lotto.NUMBERS_LENGTH - 1), 1_500_000, false),
    FORTH_PRIZE(Range.singleton(Lotto.NUMBERS_LENGTH - 2), 50_000, false),
    FIFTH_PRIZE(Range.singleton(Lotto.NUMBERS_LENGTH - 3), 5_000, false),
    NONE(Range.closed(0, Lotto.NUMBERS_LENGTH - 4), 0, false);

    private final Range<Integer> matchedCountRange;
    private final int prizeMoney;
    private final boolean isCountingBonus;

    WinningState(Range<Integer> matchedCountRange, int prizeMoney, boolean isCountingBonus) {
        this.matchedCountRange = matchedCountRange;
        this.prizeMoney = prizeMoney;
        this.isCountingBonus = isCountingBonus;
    }

    public static WinningState findByMatchedCountAndBonus(int matchedCount, boolean isContainingBonus) {
        for (WinningState value : values()) {
            if (value.matchedCountRange.contains(matchedCount)
                    && value.isCountingBonus == isContainingBonus) {
                return value;
            }
        }
        return NONE;
    }

    public Range<Integer> getMatchedCountRange() {
        return matchedCountRange;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isCountingBonus() {
        return isCountingBonus;
    }
}
