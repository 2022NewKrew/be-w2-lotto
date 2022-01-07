package model.lotto;

import model.lotto.number.LottoNumber;

public class WinningCondition {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningCondition(Lotto winningLotto, LottoNumber bonusNumber) {
        checkHasDuplicatedNumber(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank confirmLotto(Lotto lotto) {
        return LottoRank.convertToLottoRank(winningLotto.contain(lotto), lotto.contain(bonusNumber));
    }

    private void checkHasDuplicatedNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contain(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼은 당첨번호와 겹치면 안됩니다.");
        }
    }
}
