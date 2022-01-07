package com.kakaocorp.lotto.validation;

import java.util.Collection;

public class IntCollectionValidator {

    private final int expectedSize;
    private final IntRangeValidator itemValidator;

    public IntCollectionValidator(int expectedSize, int minimum, int maximum) {
        this.expectedSize = expectedSize;
        this.itemValidator = new IntRangeValidator(minimum, maximum);
    }

    public void validate(Collection<Integer> numbers) {
        if (numbers.size() != expectedSize) {
            throw new WrongSizeException(expectedSize);
        }
        for (int number : numbers) {
            itemValidator.validate(number);
        }
    }
}
