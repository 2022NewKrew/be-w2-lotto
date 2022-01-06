package lotto.domain;

import java.util.List;

public class WinTicket extends Ticket{

    private final TicketNumbers ticketNumbers;
    private final TicketNumber bonusTicketNumber;

    public WinTicket(List<Integer> ticketNumbers, int bonusTicketNumber) {
        super(ticketNumbers);
        this.ticketNumbers = new TicketNumbers(ticketNumbers);
        this.bonusTicketNumber = checkDuplicatedNumber(bonusTicketNumber);
    }

    private TicketNumber checkDuplicatedNumber(int bonusTicketNumber) {
        return ticketNumbers.checkDuplicatedNumber(bonusTicketNumber);
    }

    public Rank checkTicketRank(Ticket ticket) {
        return ticket.ticketNumbers.compareTicket(this.ticketNumbers, this.bonusTicketNumber);
    }
}
