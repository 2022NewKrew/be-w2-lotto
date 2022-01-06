package lotto.domain;

public class LottoTicket {
    public static final int PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean containLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int countMatchNumberOfLottoNumbers(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.countMatchNumberOfLottoNumbers(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
