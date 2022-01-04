package com.kakaocorp.lotto.domain;

public class ProfitCalculator {

    public float calculate(int payment, int gain) {
        return ((float) gain) / payment;
    }
}
