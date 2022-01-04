package domain;

public enum Lotto {
    LOTTO_PRICE(1000),
    NUMBER_OF_LOTTO_NUMBERS(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    ;

    private final int value;
    Lotto(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
