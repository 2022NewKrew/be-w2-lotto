package lotto.dto;

import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.WinningNumber;

public class WinningResultInput {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningResultInput(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
