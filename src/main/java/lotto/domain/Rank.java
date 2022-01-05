package lotto.domain;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private static final int MIN_MATCH_COUNT = 3;

    private final int matchCount;
    private final int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        Rank result = null;
        for (Rank rank : ranks) {
            result = rank.matchCount == countOfMatch ? rank : result;
        }
        if (countOfMatch == SECOND.matchCount) {
            return matchBonus ? SECOND : THIRD;
        }
        return result;
    }

    public static boolean isWin(int count) {
        return count >= MIN_MATCH_COUNT;
    }
}
