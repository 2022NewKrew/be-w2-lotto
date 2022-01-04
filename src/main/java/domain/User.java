package domain;

import domain.lottery.Ticket;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final Admin admin;
    private final List<Ticket> tickets;
    private int investment;

    public User(Admin admin) {
        this.admin = admin;
        investment = 0;
        tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int getInvestment() {
        return investment;
    }

    public List<Ticket> buyRandomTicketsUnderBudget(int budget) {
        List<Ticket> newTickets = new ArrayList<>();
        while (budget >= admin.getTicketPrice()) {
            newTickets.add(admin.buyRandomTicket());
            investment += admin.getTicketPrice();
            budget -= admin.getTicketPrice();
        }
        tickets.addAll(newTickets);
        return newTickets;
    }
}
