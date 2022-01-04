package lotto.domain;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int cntOfMatch;
    private int winningMoney;

    Rank(int cntOfMatch, int winningMoney) {
        this.cntOfMatch = cntOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCntOfMatch() {
        return cntOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}