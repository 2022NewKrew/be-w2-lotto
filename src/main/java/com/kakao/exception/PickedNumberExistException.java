package com.kakao.exception;

public class PickedNumberExistException extends PickedNumberException {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("중복되는 값이 이미 존재합니다.");
    }
}
