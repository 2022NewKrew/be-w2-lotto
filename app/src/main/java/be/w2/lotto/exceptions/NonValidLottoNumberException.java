package be.w2.lotto.exceptions;

public class NonValidLottoNumberException extends BusinessLogicException {
    public NonValidLottoNumberException(String message) {
        super(message);
    }
}
