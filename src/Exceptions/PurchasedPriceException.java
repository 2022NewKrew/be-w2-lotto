package Exceptions;

import Controller.LotteryController;

public class PurchasedPriceException extends Exception {
    public PurchasedPriceException() {
        LotteryController.print("구입금액을 숫자로 다시 입력해주세요.");
    }
}
