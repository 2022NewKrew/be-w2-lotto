package lotto.domain;

import java.util.List;

public class Ticket {

    public static final Integer TICKET_PRICE = 1000;
    protected final TicketNumbers ticketNumbers;

    public Ticket(List<Integer> inputTicketNumbers) {
        this.ticketNumbers = new TicketNumbers(inputTicketNumbers);
    }

    public int getMatchedNumber(WinTicket winTicket) {
        return ticketNumbers.compareTicket(winTicket.ticketNumbers);
    }

    public boolean isBonusMatched(TicketNumber bonusNumber) {
        return ticketNumbers.checkBonusMatched(bonusNumber);
    }

    // UI 전용
    public TicketNumbers getTicketNumbers() {
        return ticketNumbers;
    }
}
