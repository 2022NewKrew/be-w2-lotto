package be.w2.lotto.domain.lottonumber;

import static be.w2.lotto.common.exception.ExceptionMessages.INVALID_NUMBER_RANGE_EXCEPTION;

public class LottoNumber {
    protected final int number;

    protected LottoNumber(int lottoNumber) {
        this.number = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        validateRange(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    protected static void validateRange(int lottoNumber) throws IllegalArgumentException {
        if (lottoNumber < LOTTO_NUMBER_LOWERBOUND || lottoNumber > LOTTO_NUMBER_UPPERBOUND) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_EXCEPTION);
        }
    }

    public int getNumber() {
        return this.number;
    }

    public static final int LOTTO_NUMBER_LOWERBOUND = 1;
    public static final int LOTTO_NUMBER_UPPERBOUND = 45;
}
