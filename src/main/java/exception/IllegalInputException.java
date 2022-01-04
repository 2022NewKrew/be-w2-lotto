package exception;

public class IllegalInputException extends RuntimeException {
    public IllegalInputException() {
        super();
    }

    public IllegalInputException(String message) {
        super(message);
    }
}
