package com.chanminkim.w2.exception;

public class InvalidLottoNumberException extends RuntimeException {

    public InvalidLottoNumberException(int invalidLottoNumber) {
        super(String.format("%d is invalid lotto number.", invalidLottoNumber));
    }

}
