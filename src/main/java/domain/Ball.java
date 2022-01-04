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
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
