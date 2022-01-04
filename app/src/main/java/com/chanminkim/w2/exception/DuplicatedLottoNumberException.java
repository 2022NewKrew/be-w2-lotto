package com.chanminkim.w2.exception;

public class DuplicatedLottoNumberException extends RuntimeException {
    public DuplicatedLottoNumberException(Integer lottoNumber) {
        super(String.format("LottoNumber[%d] is already in the lotto.", lottoNumber));
    }
}
