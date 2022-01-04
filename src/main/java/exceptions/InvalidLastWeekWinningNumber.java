package exceptions;

public class InvalidLastWeekWinningNumber extends RuntimeException {
    public InvalidLastWeekWinningNumber(String errorMessage) {
        super(errorMessage);
    }
}
