package be.w2.lotto.domain.lottonumber;

import be.w2.lotto.common.exception.InvalidLottoNumberRangeException;

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
            throw new InvalidLottoNumberRangeException();
        }
    }

    public int getNumber() {
        return this.number;
    }

    public static final int LOTTO_NUMBER_LOWERBOUND = 1;
    public static final int LOTTO_NUMBER_UPPERBOUND = 45;
}
