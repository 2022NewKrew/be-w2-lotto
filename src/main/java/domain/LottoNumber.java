package domain;

import enums.LottoConstants;
import exceptions.InvalidLottoNumber;
import java.util.Objects;
import messages.ErrorMessage;
import validation.Validation;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    LottoNumber(int number) {
        Validation.notLessThanLong(number, LottoConstants.MIN_LOTTO_NUMBER.get(),
                () -> new InvalidLottoNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));
        Validation.notMoreThanLong(number, LottoConstants.MAX_LOTTO_NUMBER.get(),
                () -> new InvalidLottoNumber(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage()));

        this.number = number;
    }

    public int get() {
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

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.get();
    }
}
