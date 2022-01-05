package enums;

import java.util.Arrays;

public enum Prize {
    MISS(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int money;

    Prize(int matchCount, int money) {
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

    public int getMoney() {
        return money;
    }
}
