package lottogame.domain;

public enum Rank {
    FIRST(6, null, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, null, 50000),
    FIFTH(3, null, 5000),
    NO_RANK(0, null, 0);

    private int numberOfMatch;
    private Boolean bonusMatch;
    private int prizeMoney;

    Rank(int numberOfMatch, Boolean bonusMatch, int prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(int numberOfMatch, boolean bonusMatch) {
        Rank matched = NO_RANK;
        for (var rank : values()) {
            matched = matchRank(numberOfMatch, bonusMatch, rank, matched);
        }
        return matched;
    }

    private static Rank matchRank(int numberOfMatch, boolean bonusMatch, Rank rank, Rank previousMatched) {
        boolean isCountMatched = numberOfMatch == rank.numberOfMatch;
        boolean isBonusMatched = rank.bonusMatch != null && rank.bonusMatch.equals(bonusMatch);
        if (isCountMatched && (rank.bonusMatch == null || isBonusMatched)) {
            return rank;
        }
        return previousMatched;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int calculatePrizeMoney(int count) {
        return prizeMoney * count;
    }
}
