package com.kakao.exception;


public class PickedNumberRangeException extends PickedNumberException {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("유효한 로또 번호가 아닙니다.");
    }
}
