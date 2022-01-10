package lottogame.exception;

public class LotteryGameException extends IllegalArgumentException {
    public LotteryGameException(ErrorMessage exception) {
        super(exception.getErrorMessage());
    }
}
