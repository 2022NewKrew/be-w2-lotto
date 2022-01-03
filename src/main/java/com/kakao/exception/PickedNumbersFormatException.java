package com.kakao.exception;

public class PickedNumbersFormatException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("선택된 로또 번호의 수가 일치하지 않습니다.");
    }
}
