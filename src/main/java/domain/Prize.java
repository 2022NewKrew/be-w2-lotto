package domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000L, false),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L, false),
    FOURTH(4, 50_000L, false),
    FIFTH(3, 5_000L, false),
    MISS(0, 0L, false);

    public static Prize valueOf(int matchedNumber, boolean bonus) {
        if (matchedNumber == SECOND.matchCount && bonus)
            return SECOND;

        return Arrays.stream(Prize.values())
                .filter(i -> i.getMatchCount() == matchedNumber && !i.getBonus())
                .findAny()
                .orElse(MISS);
    }

    private final int matchCount;
    private final long money;
    private final boolean bonus;

    Prize(int matchCount, long money, boolean bonus) {
        this.matchCount = matchCount;
        this.money = money;
        this.bonus = bonus;
    }


    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return money;
    }

    public boolean getBonus() {
        return bonus;
    }
}
