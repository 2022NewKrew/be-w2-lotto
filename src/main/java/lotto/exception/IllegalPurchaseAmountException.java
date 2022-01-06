package lotto.exception;

import lotto.domain.LottoPrice;

public class IllegalPurchaseAmountException extends Exception {

    public IllegalPurchaseAmountException(String message, Throwable cause) {
        super(message + " 발생 예외: " + cause);
    }

    public IllegalPurchaseAmountException(String message, int input) {
        super(message + " 희망구매금액: " + input + " / 로또가격: " + LottoPrice.calculateLottoPurchaseAmount(1));
    }
}
