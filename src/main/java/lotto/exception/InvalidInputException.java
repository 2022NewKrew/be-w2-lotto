package lotto.exception;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("잘못된 입력 형식입니다.");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
