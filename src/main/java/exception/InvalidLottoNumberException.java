package exception;

public class InvalidLottoNumberException extends RuntimeException{
    public static final String INVALID_RANGE_NUMBER = "Lotto number has wrong range.";

    public InvalidLottoNumberException(String message) {
        super(message);
    }
}
