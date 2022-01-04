package lotto.constant;

public enum Lotto {
    PRICE(1000),
    MIN_LOTTO_NUM(1),
    MAX_LOTTO_NUM(45),
    ;

    private final int value;

    Lotto(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
