package domain.prize;

import java.util.Arrays;

public enum Prize {

    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, true, 30000000),
    THIRD_PRIZE(5, 1500000),
    FOURTH_PRIZE(4, 50000),
    FIFTH_PRIZE(3, 5000),
    NO_PRIZE(0, 0);

    private final int matchedNum;
    private final boolean matchedBonus;
    private final int prizeMoney;

    Prize(int matchedNum, int prizeMoney) {
        this.matchedNum = matchedNum;
        this.matchedBonus = false;
        this.prizeMoney = prizeMoney;
    }

    Prize(int matchedNum, boolean matchedBonus, int prizeMoney) {
        this.matchedNum = matchedNum;
        this.matchedBonus = matchedBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int matchedNum, boolean matchedBonus) {
        return Arrays.stream(values())
                .filter(p -> isEqualMatchedNum(p, matchedNum) && checkSecondPrizeForBonus(p, matchedBonus))
                .findFirst()
                .orElse(NO_PRIZE);
    }

    private static boolean isEqualMatchedNum(Prize prize, int matchedNum) {
        return prize.matchedNum == matchedNum;
    }

    private static boolean checkSecondPrizeForBonus(Prize prize, boolean matchedBonus) {
        return !SECOND_PRIZE.equals(prize) || matchedBonus;
    }

    public int getMatchedNum() {
        return matchedNum;
    }

    public boolean isMatchedBonus() {
        return matchedBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
