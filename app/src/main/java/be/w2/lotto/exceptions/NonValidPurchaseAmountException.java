package be.w2.lotto.exceptions;

public class NonValidPurchaseAmountException extends BusinessException {
    public NonValidPurchaseAmountException(String message) {
        super(message);
    }
}
