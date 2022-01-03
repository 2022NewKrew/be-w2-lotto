package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class LottoTickets implements Iterable<LottoTicket> {
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

    @Override
    public Iterator<LottoTicket> iterator() {
        return tickets.iterator();
    }
}
