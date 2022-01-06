package com.chanminkim.w2.exception;

public class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(int payment) {
        super(String.format("%d is invalid payment. It should be 0 or positive integer.", payment));
    }
}
