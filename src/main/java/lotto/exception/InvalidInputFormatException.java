package lotto.exception;

public class InvalidInputFormatException extends Exception {
    public InvalidInputFormatException() {
        super("잘못된 입력 형식입니다.");
    }

    public InvalidInputFormatException(String message) {
        super(message);
    }
}
