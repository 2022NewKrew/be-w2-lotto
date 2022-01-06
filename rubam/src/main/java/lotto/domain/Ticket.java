package lotto.domain;

import java.util.List;

public class Ticket {

    private final TicketNumbers ticketNumbers;
    public static final Integer TICKET_PRICE = 1000;

    public Ticket(List<Integer> inputTicketNumbers) {
        this.ticketNumbers = new TicketNumbers(inputTicketNumbers);
    }

    public Rank checkTicketRank(TicketNumbers winNumbers, TicketNumber bonusNumber) {
        return ticketNumbers.compareTicket(winNumbers, bonusNumber);
    }

    // UI 전용
    public TicketNumbers getTicketNumbers() {
        return ticketNumbers;
    }
}
