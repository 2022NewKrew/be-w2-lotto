package domain;

public enum MatchStatus {
    NOTHING(0, 0),
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    FIVE_MATCHES_AND_BONUS(5, 30000000, true),
    ALL_MATCHES(6, 2000000000),
    INVALID;

    private static final int NUMBER_MATCH_BALLS_2ND = 5;
    private static final int MIN_MATCH_NUM_FOR_WINNING = 3;
    private int matchCount;
    private int prizeMoney;
    private boolean isBonusMatched;

    MatchStatus() {
    }

    MatchStatus(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    MatchStatus(int matchCount, int prizeMoney, boolean isBonusMatched) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isBonusMatched = isBonusMatched;
    }

    public static MatchStatus getMatchingStatus(int matchCount, boolean isBonusMatched) {
        if (matchCount == NUMBER_MATCH_BALLS_2ND && isBonusMatched) {
            return FIVE_MATCHES_AND_BONUS;
        }
        if (isStatusInvalid(matchCount, isBonusMatched)) {
            return INVALID;
        }
        if (isStatusNothing(matchCount)) {
            return NOTHING;
        }
        for (var status : MatchStatus.values()) {
            if (status.matchCount == matchCount) {
                return status;
            }
        }
        return INVALID;
    }

    private static boolean isStatusNothing(int matchCount) {
        return (matchCount < MIN_MATCH_NUM_FOR_WINNING) && (matchCount >= 0);
    }

    private static boolean isStatusInvalid(int matchCount, boolean isBonusMatched) {
        if (matchCount < 0 || matchCount > Lotto.NUMBER_OF_BALLS) {
            return true;
        }
        return (matchCount == Lotto.NUMBER_OF_BALLS && isBonusMatched);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }
}
