package domain;

import domain.lottery.Ticket;
import dto.ReportDTO;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class User {
    private final Agent agent;
    private final List<Ticket> tickets;
    private int investment;

    public User(Agent agent) {
        this.agent = agent;
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
        while (budget >= agent.getTicketPrice()) {
            newTickets.add(agent.buyRandomTicket());
            investment += agent.getTicketPrice();
            budget -= agent.getTicketPrice();
        }
        tickets.addAll(newTickets);
        return newTickets;
    }

    public ReportDTO getReport() {
        EnumMap<Prize, Integer> prizeCount = createInitializedPrizeCount();
        for (var ticket : tickets) {
            Prize ticketPrize = agent.getTicketPrize(ticket);
            prizeCount.put(ticketPrize, prizeCount.get(ticketPrize) + 1);
        }
        return new ReportDTO(investment, prizeCount);
    }

    private EnumMap<Prize, Integer> createInitializedPrizeCount() {
        EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (var prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
        return prizeCount;
    }
}
