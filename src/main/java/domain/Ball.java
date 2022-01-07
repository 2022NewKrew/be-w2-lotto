package domain;

import java.util.Objects;

public class Ball {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final int number;

    public Ball(int number) {
        assertValidNumber(number);
        this.number = number;
    }

    private void assertValidNumber(int number) throws IllegalArgumentException {
        if (number < Ball.MIN_LOTTO_NUMBER || number > Ball.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
