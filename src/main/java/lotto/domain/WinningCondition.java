package lotto.domain;

public class WinningCondition {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningCondition(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public int countMatchNumberOfLottoTicket(LottoTicket lottoTicket) {
        return lottoTicket.countMatchNumberOfLottoNumbers(winningLottoNumbers);
    }

    public boolean containsBonusLottoNumber(LottoTicket lottoTicket) {
        return lottoTicket.containLottoNumber(bonusLottoNumber);
    }

}
