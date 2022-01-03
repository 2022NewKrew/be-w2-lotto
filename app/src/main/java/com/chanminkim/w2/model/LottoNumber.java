package com.chanminkim.w2.model;

import com.chanminkim.w2.exception.InvalidLottoNumberException;
import com.google.common.collect.Range;

public class LottoNumber {
    private static final Range<Integer> LOTTO_NUMBER_RANGE = Range.closed(1, 45);

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
}
