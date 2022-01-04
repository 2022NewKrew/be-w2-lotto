package domain;

import domain.lottery.Tickets;
import dto.ReportDTO;


public class User {
    private final Agent agent;
    private final Tickets tickets;
    private int investment;

    public User(Agent agent) {
        this.agent = agent;
        investment = 0;
        tickets = new Tickets();
    }

    public Tickets buyRandomTicketsUnderBudget(int budget) {
        Tickets newTickets = new Tickets();
        while (budget >= agent.getTicketPrice()) {
            newTickets.add(agent.buyRandomTicket());
            investment += agent.getTicketPrice();
            budget -= agent.getTicketPrice();
        }
        tickets.add(newTickets);
        return newTickets;
    }

    public ReportDTO getReport() {
        return new ReportDTO(investment, tickets.getPrizeCount(agent));
    }
}
