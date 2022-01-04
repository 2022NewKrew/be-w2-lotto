package com.kakao.exception;

<<<<<<< HEAD
<<<<<<< HEAD
public class PickedNumbersFormatException extends PickedNumberException {
=======
public class PickedNumbersFormatException extends Exception {
>>>>>>> edb2074 (1일차 중간 PR)
=======
public class PickedNumbersFormatException extends PickedNumberException {
>>>>>>> 2e87083 (- 로또 번호의 유효성 검사 추가)
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("선택된 로또 번호의 수가 일치하지 않습니다.");
    }
}
