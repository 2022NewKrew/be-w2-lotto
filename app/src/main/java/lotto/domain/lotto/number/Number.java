package lotto.domain.lotto.number;

import java.util.Objects;

public class Number {

    private final int num;

    public Number(int num) {
        validNumRange(num);
        this.num = num;
    }

    private void validNumRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        Number number = (Number) o;
        return num == number.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return "" + num + "";
    }
}
