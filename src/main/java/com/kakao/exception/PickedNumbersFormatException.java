package com.kakao.exception;

<<<<<<< HEAD
public class PickedNumbersFormatException extends PickedNumberException {
=======
public class PickedNumbersFormatException extends Exception {
>>>>>>> edb2074 (1일차 중간 PR)
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("선택된 로또 번호의 수가 일치하지 않습니다.");
    }
}
