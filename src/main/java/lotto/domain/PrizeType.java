package lotto.domain;

public enum PrizeType {
    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, 1500000),
    THIRD_PRIZE(4, 50000),
    FOURTH_PRIZE(3, 5000);

    private final int value;
    private final int money;

    PrizeType(int value, int money) {
        this.value = value;
        this.money = money;
    }

    public int getValue() {
        return value;
    }

    public int getMoney() {
        return money;
    }
}
