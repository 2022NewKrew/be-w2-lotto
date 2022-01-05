package com.yapark97.lottoapplication.domain.winningPolicy;

public enum WinningRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int winningCondition;
    private int winningPrize;

    private WinningRank(int winningCondition, int winningPrize) {
        this.winningCondition = winningCondition;
        this.winningPrize = winningPrize;
    }

    public int getWinningCondition() {
        return winningCondition;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
