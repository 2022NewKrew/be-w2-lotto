import java.util.List;

public class WinningTicket extends Ticket {
    private int bonusNumber;
    WinningTicket(List<Integer> winningNumbers) {
        this.selectedNumbers = winningNumbers;
    }
    WinningTicket(List<Integer> winningNumbers, int bonusNumber) {
        this.selectedNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
