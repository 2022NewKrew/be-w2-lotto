package Exceptions;

import Controller.LotteryController;

public class NotIntegerException extends Exception {
    public NotIntegerException() {
        LotteryController.print("숫자 이외의 데이터가 입력되었습니다. 다시 입력해 주세요.");
    }
}
