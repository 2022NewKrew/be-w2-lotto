package domain.lottery;

import domain.Prize;
import dto.TicketsDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tickets {
    private static final int TICKET_PRICE = 1000;
    private final List<Ticket> tickets;

    public Tickets() {
        tickets = new ArrayList<>();
    }

    public Map<Prize, Integer> getPrizeCount(Result result) {
        Map<Prize, Integer> prizeCount = createInitializedPrizeCount();
        for (var ticket : tickets) {
            Prize ticketPrize = Prize.getPrize(result, ticket);
            prizeCount.put(ticketPrize, prizeCount.get(ticketPrize) + 1);
        }
        return prizeCount;
    }

    private Map<Prize, Integer> createInitializedPrizeCount() {
        return Arrays.stream(Prize.values()).collect(Collectors.toMap(Function.identity(), prize -> Integer.valueOf(0)));
    }

    public void add(Ticket ticket) {
        tickets.add(ticket);
    }

    public void add(Tickets tickets) {
        this.tickets.addAll(tickets.tickets);
    }

    public void addRandomTicketsUnderBudget(int budget) {
        while (budget >= TICKET_PRICE) {
            tickets.add(new Ticket());
            budget -= TICKET_PRICE;
        }
    }

    public int getCost() {
        return TICKET_PRICE * tickets.size();
    }

    public TicketsDTO toDTO() {
        return new TicketsDTO(tickets.stream().map(ticket -> ticket.toDTO()).collect(Collectors.toList()));
    }
}
