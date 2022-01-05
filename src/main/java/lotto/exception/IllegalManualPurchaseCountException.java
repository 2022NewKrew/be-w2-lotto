package lotto.exception;

import static lotto.domain.LottoConstant.LOTTO_PRICE;

public class IllegalManualPurchaseCountException extends Exception {

    public IllegalManualPurchaseCountException(String message) {
        super(message);
    }
    public IllegalManualPurchaseCountException(String message, Throwable cause) {
        super(message + " 발생 예외: " + cause);
    }

    public IllegalManualPurchaseCountException(String message, int input, int maxNumber) {
        super(message + " 수동로또가격: " + input * LOTTO_PRICE + " / 구매금액: " + maxNumber * LOTTO_PRICE);
    }
}
