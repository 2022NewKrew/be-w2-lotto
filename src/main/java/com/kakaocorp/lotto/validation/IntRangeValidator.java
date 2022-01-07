package com.kakaocorp.lotto.validation;

public class IntRangeValidator {

    private final int minimum;
    private final int maximum;

    public static IntRangeValidator ofMinimum(int minimum) {
        return new IntRangeValidator(minimum, Integer.MAX_VALUE);
    }

    public IntRangeValidator(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public void validate(int value) {
        if (value < minimum) {
            throw new LessThanMinimumException(minimum);
        }
        if (value > maximum) {
            throw new GreaterThanMaximumException(maximum);
        }
    }
}
