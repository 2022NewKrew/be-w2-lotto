package domain;

import java.util.Arrays;

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

    Prize(int matchingNumber, boolean matchingBonus, int prizeMoney) {
        this.matchingNumber = matchingNumber;
        this.matchingBonus = matchingBonus;
        this.prizeMoney = prizeMoney;
    }

    Prize(int matchingNumber, int prizeMoney) {
        this(matchingNumber, false, prizeMoney);
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize getPrize(Integer matchingNumber, Boolean matchingBonus) {
        return Arrays.stream(values())
                        .filter(prize -> prize.matchingNumber == matchingNumber)
                        .filter(prize -> prize.matchingNumber != SECOND_PRIZE.getMatchingNumber() || prize.matchingBonus == matchingBonus)    // matchingNumber가 5개일때만 bonus를 비교한다.
                        .findFirst()
                        .orElse(NO_PRIZE);
    }
}
