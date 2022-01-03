package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.InvalidLottoNumberException;
import com.google.common.collect.Range;

import java.util.Objects;

public class LottoNumber {
    public static final Range<Integer> LOTTO_NUMBER_RANGE = Range.closed(1, 45);

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (!LOTTO_NUMBER_RANGE.contains(lottoNumber)) {
            throw new InvalidLottoNumberException(lottoNumber);
        }
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
