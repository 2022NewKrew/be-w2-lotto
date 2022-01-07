package domain;


import java.util.Objects;

import static utils.Symbol.*;

public class Number implements Comparable<Number> {
    private final int num;

    public Number(int num) {
        isValidNumber(num);
        this.num = num;
    }

    public void isValidNumber(int num) {
        if (!(MIN_LOTTO_RANGE <= num && num <= MAX_LOTTO_RANGE)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    public int getNum() {
        return this.num;
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }

    @Override
    public int compareTo(Number o) {
        return this.getNum() - o.getNum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return num == number.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
