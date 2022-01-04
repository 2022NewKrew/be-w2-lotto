package lotto.domain;

public enum Rank {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000),
    BONUS_MATCH(7, 30000000);

    private final int matchCount;
    private final long winningMoney;

    Rank(int matchCount, long winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
