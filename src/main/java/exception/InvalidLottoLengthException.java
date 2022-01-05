package exception;

public class InvalidLottoLengthException extends RuntimeException{
    public static final String INVALID_LENGTH = "Lotto number has wrong length.";
    public static final Integer LOTTO_LENGTH = 6;

    public InvalidLottoLengthException(String message) {
        super(message);
    }
}
