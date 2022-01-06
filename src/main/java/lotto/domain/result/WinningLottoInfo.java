package lotto.domain.result;

import lotto.validator.LottoValidator;

public class WinningLottoInfo {

    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLottoInfo(WinningLotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        LottoValidator.validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
