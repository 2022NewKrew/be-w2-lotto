package be.w2.lotto.common.exception;

public class LottoNumberDuplicationNotAllowedException extends RuntimeException{
    public LottoNumberDuplicationNotAllowedException() {
        super(LOTTO_NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION);
    }

    public static final String LOTTO_NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION = "로또 번호는 중복일 수 없습니다.";
}
