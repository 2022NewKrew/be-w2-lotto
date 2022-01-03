package lotto.domain;

public enum LottoInfo {
    PRICE_OF_LOTTO(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    COUNT_OF_NUMBER(6),
    MIN_MATCH_COUNT(3);

    private final int value;

    LottoInfo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}