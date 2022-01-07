package lotto.constant;

public enum Lotto {
    MIN_NUM(1),
    MAX_NUM(45),
    PICK_SIZE(6),
    ;

    private final int value;

    Lotto(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
