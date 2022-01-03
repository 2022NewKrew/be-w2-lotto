package lotto.domain;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    private LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets from(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public int getNumberOfTickets() {
        return tickets.size();
    }
}
