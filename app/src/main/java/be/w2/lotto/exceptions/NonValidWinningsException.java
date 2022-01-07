package be.w2.lotto.exceptions;

public class NonValidWinningsException extends BusinessLogicException {
    public NonValidWinningsException(String message) {
        super(message);
    }
}
