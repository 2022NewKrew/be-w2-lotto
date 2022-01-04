package domain;

import exception.IllegalInputException;

import java.util.Arrays;

public enum Prize {
    FOURTH(5000, 3, false),
    THIRD(50000, 4, false),
    SECOND(1500000, 5, false),
    SECOND_BONUS(30000000, 5, true),
    FIRST(2000000000, 6, false);

    private final int money;
    private final int correctAmount;
    private final boolean isBonus;

    Prize(int money, int correctAmount, boolean isBonus) {
        this.money = money;
        this.correctAmount = correctAmount;
        this.isBonus = isBonus;
    }

    public int getMoney() {
        return money;
    }

    public int getCorrectAmount() {
        return correctAmount;
    }

    public boolean getIsBonus() {
        return isBonus;
    }
}
