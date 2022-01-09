package lotto.exception;

public class IllegalManualLottoCountException extends RuntimeException{

    public IllegalManualLottoCountException() {
        super("입력한 로또 수가 올바르지 않습니다.")
    }

    public IllegalManualLottoCountException(String message) {
        super(message);
    }
}
