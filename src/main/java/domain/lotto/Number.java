package domain.lotto;

import java.util.Objects;

public class Number implements Comparable<Number> {
    private final int value;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public int compareTo(Number o) {
        return this.value - o.value;
    }

    public Number(int value) {
        isValid(value);
        this.value = value;
    }

    private void isValid(int value) {
        if (MIN_NUMBER <= value && value <= MAX_NUMBER) {
            return;
        }
        throw new IllegalArgumentException("숫자가 로또 범위를 초과하였습니다.");
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
