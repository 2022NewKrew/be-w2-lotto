package lotto.exception;

import lotto.domain.LottoPrice;

public class IllegalManualPurchaseCountException extends Exception {

    public IllegalManualPurchaseCountException(String message) {
        super(message);
    }
    public IllegalManualPurchaseCountException(String message, Throwable cause) {
        super(message + " 발생 예외: " + cause);
    }

    public IllegalManualPurchaseCountException(String message, int input, int maxNumber) {
        super(message + " 수동로또가격: " + LottoPrice.calculateLottoPurchaseAmount(input) + " / 구매금액: " + LottoPrice.calculateLottoPurchaseAmount(maxNumber));
    }
}
