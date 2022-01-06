package lotto.domain.userinput;

import lotto.domain.Lotto;
import lotto.domain.util.LottoValidator;

public class WinningLottoDto {
    private final Lotto winningTicket;
    private final int bonusBall;

    public WinningLottoDto(Lotto winningTicket, int bonusBall) {
        this.winningTicket = winningTicket;
        this.bonusBall = bonusBall;
        winningTicket.validateWithBonusBall(bonusBall);
    }

    public Lotto getWinningTicket() {
        return winningTicket;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}