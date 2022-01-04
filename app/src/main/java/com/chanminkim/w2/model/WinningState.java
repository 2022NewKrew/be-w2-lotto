package com.chanminkim.w2.model;

import java.util.HashMap;
import java.util.Map;

public enum WinningState {
    FIRST_PRIZE(Lotto.LOTTO_NUMBERS_LENGTH_LIMIT, 2_000_000_000),
    SECOND_PRIZE(Lotto.LOTTO_NUMBERS_LENGTH_LIMIT - 1, 1_500_000),
    THIRD_PRIZE(Lotto.LOTTO_NUMBERS_LENGTH_LIMIT - 2, 50_000),
    FORTH_PRIZE(Lotto.LOTTO_NUMBERS_LENGTH_LIMIT - 3, 5_000);

    private final int matchedCount;
    private final int prizeMoney;

    private static final Map<Integer, WinningState> MATCHED_COUNT_MAP;

    static {
        MATCHED_COUNT_MAP = new HashMap<>();
        for (WinningState state : WinningState.values()) {
            MATCHED_COUNT_MAP.put(state.matchedCount, state);
        }
    }

    WinningState(int matchedCount, int prizeMoney) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningState findByMatchedCount(int matchedCount) {
        return MATCHED_COUNT_MAP.get(matchedCount);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
