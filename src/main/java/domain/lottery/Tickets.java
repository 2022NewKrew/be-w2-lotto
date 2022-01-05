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
    private final List<Ticket> tickets;
    private final int ticketPrice;

    public Tickets(int ticketPrice) {
        this.ticketPrice = ticketPrice;
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

    public int getCost() {
        return ticketPrice * tickets.size();
    }

    public TicketsDTO toDTO() {
        return new TicketsDTO(tickets.stream().map(ticket -> ticket.toDTO()).collect(Collectors.toList()));
    }
}
