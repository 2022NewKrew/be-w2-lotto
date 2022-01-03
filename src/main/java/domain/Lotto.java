package domain;

public enum Lotto {
    ZERO(0),
    LOTTO_PRICE(1000),
    NUMBER_OF_LOTTO_NUMBERS(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    FIRST_PLACE(2_000_000_000),
    SECOND_PLACE(1_500_000),
    THIRD_PLACE(50_000),
    FOURTH_PLACE(5000),
    ;

    private final int value;
    Lotto(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
