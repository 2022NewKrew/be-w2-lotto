package be.w2.lotto.exceptions;

import be.w2.lotto.exceptions.BusinessException;

public class NonValidPurchaseAmountException extends BusinessException {
    public NonValidPurchaseAmountException(String message) {
        super(message);
    }
}
