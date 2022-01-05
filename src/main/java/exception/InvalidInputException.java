package exception;

import static utils.Symbol.INPUT_FORMAT_EXCEPTION;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super(INPUT_FORMAT_EXCEPTION);
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
