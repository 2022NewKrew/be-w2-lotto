package be.w2.lotto.exceptions;

public class NonValidPurchaseAmountException extends BusinessLogicException {
    public NonValidPurchaseAmountException(String message) {
        super(message);
    }
}
