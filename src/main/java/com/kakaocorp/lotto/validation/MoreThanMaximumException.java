package com.kakaocorp.lotto.validation;

public class MoreThanMaximumException extends IllegalArgumentException {

    private final int maximum;

    public MoreThanMaximumException(int maximum) {
        this.maximum = maximum;
    }

    public int getMaximum() {
        return maximum;
    }
}
