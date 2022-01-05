package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        DomainValidationChecker checker = new DomainValidationChecker();
        checker.checkDuplicationInWinningLotto(lotto, bonusNumber);
        checker.checkLottoNumber(bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
