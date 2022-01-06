package com.kakaocorp.lotto.validation;

public class WrongSizeException extends IllegalArgumentException {

    private final int expectedSize;

    public WrongSizeException(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    public int getExpectedSize() {
        return expectedSize;
    }
}
