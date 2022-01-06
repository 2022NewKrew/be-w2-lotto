package com.chanminkim.w2.exception;

public class InvalidNumberOfLottoException extends RuntimeException {
    public InvalidNumberOfLottoException(int numberOfLotto) {
        super(String.format("%d is invalid number of lotto.", numberOfLotto));
    }
}
