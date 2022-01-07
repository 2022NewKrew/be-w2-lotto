package be.w2.lotto.common.exception;

public class InvalidLottoNumberRangeException extends RuntimeException{
    public InvalidLottoNumberRangeException() {
        super(INVALID_LOTTO_NUMBER_RANGE_EXCEPTION);
    }

    public static final String INVALID_LOTTO_NUMBER_RANGE_EXCEPTION = "로또 번호는 1 이상 45 이하입니다.";
}
