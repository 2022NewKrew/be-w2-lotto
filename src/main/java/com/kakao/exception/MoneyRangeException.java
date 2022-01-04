package com.kakao.exception;

public class MoneyRangeException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("입력된 돈이 허용범위가 아닙니다.");
    }
}
