package lotto.domain.userinput;

import lotto.domain.Lotto;
import lotto.domain.util.LottoValidator;

public class WinningLottoInput {
    private static final LottoValidator VALIDATOR = new LottoValidator();

    private final Lotto winningTicket;
    private final int bonusBall;

    public WinningLottoInput(Lotto winningTicket, int bonusBall) {
        this.winningTicket = winningTicket;
        this.bonusBall = bonusBall;
        VALIDATOR.validateBonusBall(winningTicket.getNumbers(), bonusBall);
    }

    public Lotto getWinningTicket() {
        return winningTicket;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}