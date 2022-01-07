package exception;

public class InvalidLottoNumberException extends RuntimeException{
    public static final String INVALID_RANGE_NUMBER = "Lotto number has wrong range.";
    public static final String INVALID_BONUS_BALL = "Bonus ball should not in Lotto";

    public InvalidLottoNumberException(String message) {
        super(message);
    }
}
