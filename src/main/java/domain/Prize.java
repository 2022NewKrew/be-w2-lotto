package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    None(0, 0);

    private static final Map<Integer, Prize> matchingCountToPrize;

    static {
        matchingCountToPrize = new HashMap<>();
        Arrays.asList(Prize.values()).forEach(prize -> matchingCountToPrize.put(prize.winningMatchingCount, prize));
    }

    private final int winningMatchingCount;
    private final int value;

    Prize(int winningMatchingCount, int value) {
        this.winningMatchingCount = winningMatchingCount;
        this.value = value;
    }

    public static Prize getPrizeByMatchingCount(int matchingCount) {
        return matchingCountToPrize.getOrDefault(matchingCount, Prize.None);
    }

    public int getWinningMatchingCount() {
        return winningMatchingCount;
    }

    public int getValue() {
        return value;
    }
}
