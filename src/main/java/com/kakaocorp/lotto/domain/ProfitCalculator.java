package com.kakaocorp.lotto.domain;

public class ProfitCalculator {

    public float calculate(int payment, int gain) {
        if (gain > payment) {
            return 1 + (gain - payment) / ((float) payment);
        }
        return (gain - payment) / ((float) payment);
    }
}
