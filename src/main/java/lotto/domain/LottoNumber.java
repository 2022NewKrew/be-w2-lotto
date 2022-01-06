package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static lotto.view.LottoOutputPrinter.CHECK_LOTTO_NUMBER_MESSAGE;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        checkLottoNumber(number);
        this.number = number;
    }

    private void checkLottoNumber(int number) {
        if (MIN_NUMBER > number || number > MAX_NUMBER)
            throw new IllegalArgumentException(CHECK_LOTTO_NUMBER_MESSAGE);
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
