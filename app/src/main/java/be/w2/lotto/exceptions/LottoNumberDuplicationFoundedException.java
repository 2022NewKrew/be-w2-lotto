package be.w2.lotto.exceptions;

public class LottoNumberDuplicationFoundedException extends BusinessLogicException {
    public LottoNumberDuplicationFoundedException(String message) {
        super(message);
    }
}
