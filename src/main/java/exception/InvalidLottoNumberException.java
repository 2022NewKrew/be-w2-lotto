package exception;

public class InvalidLottoNumberException extends RuntimeException{
    public static final String INVALID_RANGE_NUMBER = "Lotto number has wrong range.";
    public static final String INVALID_INTEGER_NUMBER = "Lotto number should be Integer.";

    public InvalidLottoNumberException(String message) {
        super(message);
    }
}
