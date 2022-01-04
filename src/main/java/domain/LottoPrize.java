package domain;

import java.util.Arrays;

public enum LottoPrize {
    NOTHING(0, 0, false),
    FIFTH_PLACE(3, 5000, false),
    FOURTH_PLACE(4, 50_000, false),
    THIRD_PLACE(5, 1_500_000, false),
    SECOND_PLACE(5, 30_000_000, true),
    FIRST_PLACE(6, 2_000_000_000, false),
    ;

    private final int numberOfMatches;
    private final long prizeMoney;
    private final boolean allowBonusBall;

    LottoPrize(int numberOfMatches, long prizeMoney, boolean allowBonusBall) {
        this.numberOfMatches = numberOfMatches;
        this.prizeMoney = prizeMoney;
        this.allowBonusBall = allowBonusBall;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoPrize getLottoRank(long numberOfMatches, boolean matchesBonusBall) {
        return Arrays.stream(values())
                .filter(value -> value.numberOfMatches == numberOfMatches && value.allowBonusBall && matchesBonusBall)
                .findFirst()
                .orElse(NOTHING);
    }
}
