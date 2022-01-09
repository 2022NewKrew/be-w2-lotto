package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tickets {

    private final List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Map<Rank, Integer> winRankStatistics(WinTicket winTicket) {
        Map<Rank, Integer> results = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> {
            results.put(rank, 0);
        });
        tickets.forEach(ticket -> {
            results.merge(winTicket.checkTicketRank(ticket), 1, Integer::sum);
        });
        return results;
    }
}