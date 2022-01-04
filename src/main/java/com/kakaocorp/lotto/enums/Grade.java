package com.kakaocorp.lotto.enums;

public enum Grade {

    FIRST(2000000000), SECOND(30000000), THIRD(1500000),
    FOURTH(50000), FIFTH(5000), NO_GRADE(0);

    private int winningMoney;

    Grade(int winningMoney) {
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
