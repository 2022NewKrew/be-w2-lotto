package domain;

import java.util.Collections;

public enum MatchNumber {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final Integer value;

    MatchNumber(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
