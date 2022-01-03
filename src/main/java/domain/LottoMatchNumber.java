package domain;

public enum LottoMatchNumber {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final Integer value;

    LottoMatchNumber(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
    }
