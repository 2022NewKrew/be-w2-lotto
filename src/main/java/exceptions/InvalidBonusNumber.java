package exceptions;

public class InvalidBonusNumber extends RuntimeException {
    public InvalidBonusNumber(String errorMessage) {
        super(errorMessage);
    }
}

