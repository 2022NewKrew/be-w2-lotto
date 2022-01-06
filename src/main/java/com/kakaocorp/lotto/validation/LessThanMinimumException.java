package com.kakaocorp.lotto.validation;

public class LessThanMinimumException extends IllegalArgumentException {

    private final int minimum;

    public LessThanMinimumException(int minimum) {
        this.minimum = minimum;
    }

    public int getMinimum() {
        return minimum;
    }
}
