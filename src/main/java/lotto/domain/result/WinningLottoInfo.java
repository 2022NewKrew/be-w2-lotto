package lotto.domain.result;

public class WinningLottoInfo {

    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLottoInfo(WinningLotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(BonusNumber bonusNumber){
        if (winningLotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
