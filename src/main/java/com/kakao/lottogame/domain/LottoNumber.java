package com.kakao.lottogame.domain;

public class LottoNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }

    private void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("1부터 45까지의 번호를 선택할 수 있습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumber lottoNumber = (LottoNumber) o;

        return getValue() == lottoNumber.getValue();
    }

    @Override
    public int hashCode() {
        return getValue();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
