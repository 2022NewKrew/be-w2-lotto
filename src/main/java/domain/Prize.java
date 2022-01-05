package domain;

import java.util.Arrays;

public enum Prize {
    NONE(0, 0, false),
    FOURTH(3, 5000, false),
    THIRD(4, 50000, false),
    SECOND(5, 1500000, false),
    SECOND_BONUS(5, 30000000, true),
    FIRST(6, 2000000000, false);


    final int matchCount;
    final int money;
    final boolean hasBonusNumber;

    Prize(int matchCount, int money, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.money = money;
        this.hasBonusNumber = hasBonusNumber;
    }

    static boolean isThisPrize(Prize prize, int matchedCount, boolean hasBonusNumber) {
        if (prize.matchCount != matchedCount) return false;
        if (prize == SECOND && hasBonusNumber) return false;
        return prize != SECOND_BONUS || hasBonusNumber;
    }

    public static Prize getLottoPrize(Lotto lotto, Winning winning) {
        long matchedCount = winning.getNumbers().stream().filter(number -> lotto.getNumbers().contains(number)).count();
        boolean hasBonusNumber = lotto.getNumbers().contains(winning.getBonusNumber());

        return Arrays.stream(values()).filter(prize -> isThisPrize(prize, (int) matchedCount, hasBonusNumber)).findFirst().orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }
}
