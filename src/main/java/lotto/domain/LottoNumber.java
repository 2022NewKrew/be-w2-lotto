package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int digit;

    public LottoNumber(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    @Override
    public int compareTo(@NotNull LottoNumber lottoNumber) {
        return this.digit - lottoNumber.getDigit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return digit == that.digit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }
}
