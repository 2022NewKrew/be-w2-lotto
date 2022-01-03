package com.kakao.lottogame.domain;

public class Money {

    private final int value;

    private Money(int value) {
        validate(value);
        this.value = value;
    }

    public static Money of(int value) {
        return new Money(value);
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("0보다 작은 값은 허용하지 않습니다.");
        }
    }

    public int buy(Money price) {
        return this.value / price.value;
    }

    public int getValue() {
        return value;
    }
}
