package Domain.Tickets;

import java.util.List;

public class WinningTicket extends Ticket {
    private int bonusNumber;

    public WinningTicket(List<Integer> winningNumbers, int bonusNumber) {
        this.selectedNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
