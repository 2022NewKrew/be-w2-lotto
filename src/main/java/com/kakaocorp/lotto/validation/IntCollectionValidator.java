package com.kakaocorp.lotto.validation;

import java.util.Collection;

public class IntCollectionValidator {

    private final int expectedSize;
    private final int minimum;
    private final int maximum;

    public IntCollectionValidator(int expectedSize, int minimum, int maximum) {
        this.expectedSize = expectedSize;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public void validate(Collection<Integer> numbers) {
        if (numbers.size() != expectedSize) {
            throw new WrongSizeException(expectedSize);
        }
        if (numbers.stream().anyMatch(n -> n < minimum)) {
            throw new LessThanMinimumException(minimum);
        }
        if (numbers.stream().anyMatch(n -> n > maximum)) {
            throw new MoreThanMaximumException(maximum);
        }
    }
}
