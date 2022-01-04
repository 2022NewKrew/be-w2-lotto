package org.cs.finn.lotto.domain.lotto;

import org.cs.finn.lotto.util.Checker;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final LottoNumber NONE = new LottoNumber();
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int number;

    public LottoNumber(final String value)
            throws IllegalArgumentException, IllegalStateException, IndexOutOfBoundsException
    {
        Checker.checkIntMinMax(MIN, MAX);
        Checker.checkString(value);

        int temp = Integer.parseInt(value.trim(), 10);
        Checker.checkIntBound(temp, MIN, MAX);
        this.number = temp;
    }

    public LottoNumber(final int value)
            throws IllegalStateException, IndexOutOfBoundsException
    {
        Checker.checkIntBound(value, MIN, MAX);
        this.number = value;
    }

    private LottoNumber() {
        this.number = 0;
    }

    public boolean isNone() {
        return this.equals(NONE);
    }

    public int get() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    // Auto-generated code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    // Auto-generated code
    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.get(), o.get());
    }
}
