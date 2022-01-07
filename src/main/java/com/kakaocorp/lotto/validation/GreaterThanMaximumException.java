package com.kakaocorp.lotto.validation;

public class GreaterThanMaximumException extends IllegalArgumentException {

    private final int maximum;

    public GreaterThanMaximumException(int maximum) {
        this.maximum = maximum;
    }

    public int getMaximum() {
        return maximum;
    }
}
