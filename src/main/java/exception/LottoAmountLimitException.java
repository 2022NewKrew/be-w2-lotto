package exception;

public class LottoAmountLimitException extends RuntimeException {
    public LottoAmountLimitException(String message) {
        super(message);
    }
}
