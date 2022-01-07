package domain;

import exceptions.InvalidLastWeekWinningNumber;
import java.util.Objects;
import messages.ErrorMessage;
import validation.Validation;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    LottoNumber(int number) {
        Validation.notLessThanLong(number, MIN_LOTTO_NUMBER,
                new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
        Validation.notMoreThanLong(number, MAX_LOTTO_NUMBER,
                new InvalidLastWeekWinningNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));

        this.number = number;
    }

    int get() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
