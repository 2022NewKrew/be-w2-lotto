package com.kakaocorp.lotto.validation;

public class ValueNotAllowedException extends IllegalArgumentException {

    private final int value;

    public ValueNotAllowedException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
