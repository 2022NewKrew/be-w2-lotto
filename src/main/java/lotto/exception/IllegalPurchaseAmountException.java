package lotto.exception;

import static lotto.domain.LottoConstant.LOTTO_PRICE;

public class IllegalPurchaseAmountException extends Exception {

    public IllegalPurchaseAmountException(String message, Throwable cause) {
        super(message + " 발생 예외: " + cause);
    }

    public IllegalPurchaseAmountException(String message, int input) {
        super(message + " 희망구매금액: " + input + " / 로또가격: " + LOTTO_PRICE);
    }
}
