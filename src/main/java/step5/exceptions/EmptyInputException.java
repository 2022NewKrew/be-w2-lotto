package step5.exceptions;

public class EmptyInputException extends RuntimeException {
    public EmptyInputException(String message) {
        super(message);
    }
}