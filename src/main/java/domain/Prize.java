package domain;

public enum Prize {
    NO_PRIZE(0, 0),
    FIFTH_PRIZE(3, 5000),
    FOURTH_PRIZE(4, 50000),
    THIRD_PRIZE(5, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, 2000000000);

    private final int matchingNumber;
    private final boolean matchingBonus;
    private final int prizeMoney;

    Prize(int matchingNumber, int prizeMoney) {
        this.matchingNumber = matchingNumber;
        this.matchingBonus = false;
        this.prizeMoney = prizeMoney;
    }

    Prize(int matchingNumber, boolean matchingBonus, int prizeMoney) {
        this.matchingNumber = matchingNumber;
        this.matchingBonus = matchingBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize getPrize(Integer num, Boolean bonus) {
        if(num == FIRST_PRIZE.matchingNumber)
        {
            return FIRST_PRIZE;
        }
        if(num == SECOND_PRIZE.matchingNumber && bonus == SECOND_PRIZE.matchingBonus)
        {
            return SECOND_PRIZE;
        }
        if(num == THIRD_PRIZE.matchingNumber && bonus == THIRD_PRIZE.matchingBonus)
        {
            return THIRD_PRIZE;
        }
        if(num == FOURTH_PRIZE.matchingNumber)
        {
            return FOURTH_PRIZE;
        }
        if(num == FIFTH_PRIZE.matchingNumber)
        {
            return FIFTH_PRIZE;
        }
        return NO_PRIZE;
    }
}
