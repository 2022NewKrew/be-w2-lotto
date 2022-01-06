package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("로또 넘버는 " + MIN_VALUE + "와 " + MAX_VALUE + "사이의 숫자여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.value;
    }

}
