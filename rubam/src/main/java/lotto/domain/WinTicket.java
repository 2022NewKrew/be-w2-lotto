package lotto.domain;

import java.util.List;

public class WinTicket {

    private final TicketNumbers ticketNumbers;
    private final TicketNumber bonusTicketNumber;

    public WinTicket(List<Integer> ticketNumbers, int bonusTicketNumber) {
        this.ticketNumbers = new TicketNumbers(ticketNumbers);
        this.bonusTicketNumber = checkDuplicatedNumber(bonusTicketNumber);
    }

    private TicketNumber checkDuplicatedNumber(int bonusTicketNumber) {
        return ticketNumbers.checkDuplicatedNumber(bonusTicketNumber);
    }

    public TicketNumbers getTicketNumbers() {
        return ticketNumbers;
    }

    public TicketNumber getBonusTicketNumber() {
        return bonusTicketNumber;
    }
}
