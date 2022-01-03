package com.chanminkim.w2.exception;

public class InvalidLottoNumbersLengthException extends RuntimeException {
    public InvalidLottoNumbersLengthException(int length) {
        super(String.format("%d is invalid length of lotto numbers.", length));
    }
}
