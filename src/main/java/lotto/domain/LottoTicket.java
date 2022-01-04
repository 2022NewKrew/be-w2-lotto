package lotto.domain;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int getLottoMatchCount(LottoNumbers winningNumbers) {
        return lottoNumbers.getLottoMatchCount(winningNumbers);
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
