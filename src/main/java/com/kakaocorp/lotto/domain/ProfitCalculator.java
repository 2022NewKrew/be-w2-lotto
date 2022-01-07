package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.validation.IntInvalidValueValidator;

import java.util.Set;

public class ProfitCalculator {

    private final IntInvalidValueValidator paymentValidator = new IntInvalidValueValidator(Set.of(0));

    public float calculate(int payment, int gain) {
        paymentValidator.validate(payment);
        return (gain - payment) / ((float) payment);
    }
}
