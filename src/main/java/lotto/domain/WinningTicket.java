package lotto.domain;

import java.util.List;

public class WinningTicket extends Ticket {
    private final int bonusNumber;

    private void checkBonusNumberValidity(int bonusNumber) throws IllegalArgumentException {
        checkSingleNumberBound(bonusNumber);
        if (getTicketNumbers().contains(bonusNumber))
            throw new IllegalArgumentException("보너스 볼의 숫자는 당첨 번호와 겹칠 수 없습니다.");
    }

    public WinningTicket(List<Integer> winningNumber, int bonusNumber) {
        super(winningNumber);
        checkBonusNumberValidity(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {return this.bonusNumber;}
}
