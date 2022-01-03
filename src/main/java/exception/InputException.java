package exception;

public class InputException extends RuntimeException {
    public InputException(String message) {
        super(message);
    }

    public static InputException NumberFormatException() {
        return new InputException("숫자 형식이 아닙니다");
    }
}
