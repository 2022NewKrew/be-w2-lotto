package enums;

import java.util.Arrays;

public enum Prize {
    MISS(0, 0L),
    THREE(3, 5_000L),
    FOUR(4, 50_000L),
    FIVE(5, 1_500_000L),
    SIX(6, 2_000_000_000L);

    private final int matchCount;
    private final long money;

    Prize(int matchCount, long money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Prize valueOf(int matchedNumber) {
        return Arrays.stream(Prize.values())
                .filter(i -> i.getMatchCount() == matchedNumber)
                .findAny()
                .orElse(MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return money;
    }
}
