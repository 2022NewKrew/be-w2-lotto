package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {

    private final List<Ticket> tickets = new ArrayList<>();
    private final Money money;

    public Customer(Money money) {
        this.money = money;
    }

    public void buyTickets(TicketsGenerator ticketsGenerator, int count) {
        tickets.addAll(money.buyTickets(ticketsGenerator, count));
    }

    public void buyAllTickets(TicketsGenerator ticketsGenerator) {
        tickets.addAll(money.buyAllTickets(ticketsGenerator));
    }

    public Map<Rank, Integer> calculateRankResult(WinTicket winTicket) {
        Map<Rank, Integer> results = new HashMap<>() {{
            put(Rank.FIRST, 0);
            put(Rank.SECOND, 0);
            put(Rank.THIRD, 0);
            put(Rank.FOURTH, 0);
            put(Rank.FIFTH, 0);
        }};

        tickets.stream().filter(ticket -> (ticket.checkTicketRank(winTicket.getTicketNumbers(), winTicket.getBonusTicketNumber()) != null))
                .forEach(ticket -> {
                    results.merge(ticket.checkTicketRank(winTicket.getTicketNumbers(), winTicket.getBonusTicketNumber()), 1, Integer::sum);
                });
        return results;
    }

    // UI 전용
    public List<Ticket> getTickets() {
        return tickets;
    }
}
