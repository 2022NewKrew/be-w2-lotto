package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class DirectTicketsGenerator implements TicketsGenerator {

    private final List<List<Integer>> ticketsNumbers;

    public DirectTicketsGenerator(List<List<Integer>> ticketsNumbers) {
        this.ticketsNumbers = ticketsNumbers;
    }

    @Override
    public List<Ticket> generateTickets(int count) {
        List<Ticket> tickets = new ArrayList<>();
        ticketsNumbers.forEach(ticketNumbers -> {
            tickets.add(new Ticket(ticketNumbers));
        });
        return tickets;
    }
}
