package be.w2.lotto.exceptions;

public class LottoNumberDuplicationFoundedException extends BusinessException {
    public LottoNumberDuplicationFoundedException(String message) {
        super(message);
    }
}
