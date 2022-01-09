package lotto.exception;

public class IllegalManualLottoInputException extends RuntimeException {
    public IllegalManualLottoInputException() {
        super("올바르지 않은 입력입니다.");
    }

    public IllegalManualLottoInputException(String message) {
        super(message);
    }
}
