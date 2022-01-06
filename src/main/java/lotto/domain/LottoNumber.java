package lotto.domain;

import lotto.IllegalLottoNumberException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) throws IllegalLottoNumberException {
        checkLottoNumber(number);
        this.number = number;
    }

    private void checkLottoNumber(int number) throws IllegalLottoNumberException {
        if (MIN_NUMBER > number || number > MAX_NUMBER)
            throw new IllegalLottoNumberException();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(@NotNull LottoNumber lottoNumber) {
        return Integer.compare(number, lottoNumber.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
