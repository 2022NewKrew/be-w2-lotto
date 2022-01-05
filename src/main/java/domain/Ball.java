package domain;

import validator.LottoValidator;

public class Ball {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final int number;

    public Ball(int number) {
        LottoValidator.assertValidNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
