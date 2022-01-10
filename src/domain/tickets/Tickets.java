package domain.tickets;

import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private int totalPrice = 0;
    private List<Ticket> tickets = new ArrayList<>();

    public Tickets() {
    }

    Tickets(List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            this.tickets.add(ticket);
            totalPrice += ticket.price;
        }
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public void add(Ticket ticket) {
        this.tickets.add(ticket);
    }
}
