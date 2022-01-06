package domain.tickets;

import java.util.List;

public class WinningTicket extends Ticket {
    private int bonusBall;

    public WinningTicket(List<Integer> winningNumbers, int bonusNumber) {
        this.selectedNumbers = winningNumbers;
        this.bonusBall = bonusNumber;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
