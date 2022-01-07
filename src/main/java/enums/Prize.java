package enums;

import java.util.Arrays;

public enum Prize {
    MISS(0, 0L, false),
    THREE(3, 5_000L, false),
    FOUR(4, 50_000L, false),
    FIVE(5, 1_500_000L, false),
    BONUS(5, 30_000_000L, true),
    SIX(6, 2_000_000_000L, false);

    public static Prize valueOf(int matchedNumber, boolean bonus) {
        boolean checkedBonus = matchedNumber == BONUS.matchCount && bonus;
        return Arrays.stream(Prize.values())
                .filter(i -> i.getMatchCount() == matchedNumber && i.getBonus() == checkedBonus)
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
