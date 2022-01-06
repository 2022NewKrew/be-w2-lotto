package com.kakaocorp.lotto.domain;

public class ProfitCalculator {

    public float calculate(int payment, int gain) {
        return (gain - payment) / ((float) payment);
    }
}
