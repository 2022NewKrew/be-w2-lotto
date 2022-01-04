package domain.prize;

public enum Prize {

    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, true, 30000000),
    THIRD_PRIZE(5, 1500000),
    FOURTH_PRIZE(4, 50000),
    FIFTH_PRIZE(3, 5000),
    NO_PRIZE(0, 0);

    public static final int FIRST_PRIZE_COUNT = 6;
    public static final int SECOND_PRIZE_COUNT = 5;
    public static final int THIRD_PRIZE_COUNT = 4;
    public static final int FOURTH_PRIZE_COUNT = 3;
    public static final int FIFTH_PRIZE_COUNT = 2;

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

    public int getMatchedNum() {
        return matchedNum;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }


}
