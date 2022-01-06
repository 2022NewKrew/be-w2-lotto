package com.kakao.lottogame.domain;

public class Money {

    private final int principal;
    private int value;

    private Money(int value) {
        validate(value);
        this.principal = value;
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

    public int divide(Money money) {
        return value / money.value;
    }

    public int getPrincipal() {
        return principal;
    }

    public int getValue() {
        return value;
    }

    public void buyLotto(int num) {
        if (this.value < Lotto.PRICE.getValue() * num) {
            throw new IllegalArgumentException("잔금이 부족합니다.");
        }
        this.value -= Lotto.PRICE.getValue() * num;
    }
}
