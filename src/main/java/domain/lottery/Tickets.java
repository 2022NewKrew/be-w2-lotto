package domain.lottery;

import domain.Agent;
import domain.Prize;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Tickets {
    private final List<Ticket> tickets;

    public Tickets() {
        tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Map<Prize, Integer> getPrizeCount(Agent agent) {
        Map<Prize, Integer> prizeCount = createInitializedPrizeCount();
        for (var ticket : tickets) {
            Prize ticketPrize = agent.getTicketPrize(ticket);
            prizeCount.put(ticketPrize, prizeCount.get(ticketPrize) + 1);
        }
        return prizeCount;
    }

    private Map<Prize, Integer> createInitializedPrizeCount() {
        EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (var prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
        return prizeCount;
    }

    public void add(Ticket ticket) {
        tickets.add(ticket);
    }

    public void add(Tickets tickets) {
        this.tickets.addAll(tickets.tickets);
    }
}
