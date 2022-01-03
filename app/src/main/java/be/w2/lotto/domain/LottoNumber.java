package be.w2.lotto.domain;

public class LottoNumber {
    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(Integer lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public static final int LOTTO_NUMBER_LOWERBOUND = 1;
    public static final int LOTTO_NUMBER_UPPERBOUND = 45;
}
