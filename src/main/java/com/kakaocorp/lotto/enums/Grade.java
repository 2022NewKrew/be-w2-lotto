package com.kakaocorp.lotto.enums;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Grade {

    FIRST(2000000000, 6), SECOND(30000000, 7), THIRD(1500000, 5),
    FOURTH(50000, 4), FIFTH(5000, 3), NO_GRADE(0, 2);

    private static final Map<Integer, String> MATCH_INDEX_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Grade::getMatchIndex, Grade::name))
    );

    private final int winningMoney;
    private final int matchIndex;

    Grade(int winningMoney, int matchIndex) {
        this.winningMoney = winningMoney;
        this.matchIndex = matchIndex;
    }

    public static Grade of(final int matchIndex) {
        return Grade.valueOf(MATCH_INDEX_MAP.get(matchIndex));
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchIndex() {
        return matchIndex;
    }
}
