package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.InvalidLottoNumberException;
import com.google.common.collect.Range;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final Range<Integer> LOTTO_NUMBER_RANGE = Range.closed(1, 45);

    private final int value;

    public LottoNumber(int value) {
        if (!LOTTO_NUMBER_RANGE.contains(value)) {
            throw new InvalidLottoNumberException(value);
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }
}
