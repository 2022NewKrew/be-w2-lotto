package model.lotto;

import model.lotto.number.LottoNumber;

public class WinningCondition {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningCondition(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank compareTo(Lotto lotto) {
        return LottoRank.convertToLottoRank(winningLotto.contain(lotto), lotto.contain(bonusNumber));
    }
}
