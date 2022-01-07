package lotto.domain;

import java.util.List;

public class Ticket {

    protected final TicketNumbers ticketNumbers;
    public static final Integer TICKET_PRICE = 1000;

    public Ticket(List<Integer> inputTicketNumbers) {
        this.ticketNumbers = new TicketNumbers(inputTicketNumbers);
    }

    // UI 전용
    public TicketNumbers getTicketNumbers() {
        return ticketNumbers;
    }
}
