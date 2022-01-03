package com.chanminkim.w2.exception;

import com.chanminkim.w2.model.LottoNumber;

public class DuplicatedLottoNumberException extends RuntimeException {
    public DuplicatedLottoNumberException(LottoNumber lottoNumber) {
        super(String.format("LottoNumber %d is already in lotto.", lottoNumber.getLottoNumber()));
    }
}
