package com.kakaocorp.lotto.validation;

import java.util.Set;

public class IntInvalidValueValidator {

    private final Set<Integer> invalid;

    public IntInvalidValueValidator(Set<Integer> invalid) {
        this.invalid = invalid;
    }

    public void validate(int value) {
        if (invalid.contains(value)) {
            throw new ValueNotAllowedException(value);
        }
    }
}
