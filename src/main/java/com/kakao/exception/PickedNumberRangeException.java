package com.kakao.exception;

<<<<<<< HEAD
<<<<<<< HEAD
public class PickedNumberRangeException extends PickedNumberException {
=======
public class PickedNumberRangeException extends Exception {
>>>>>>> 231c634 (1차 PR 리뷰 개선)
=======
public class PickedNumberRangeException extends PickedNumberException {
>>>>>>> 2e87083 (- 로또 번호의 유효성 검사 추가)
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("유효한 로또 번호가 아닙니다.");
    }
}
