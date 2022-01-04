package domain;

import domain.lottery.Tickets;
import dto.ReportDTO;


public class Purchase {
    private final Agent agent;
    private final Tickets tickets;
    private int investment;
    private int ticketPrice;

    public Purchase(Agent agent, int ticketPrice) {
        this.ticketPrice = ticketPrice;
        this.agent = agent;
        investment = 0;
        tickets = new Tickets();
    }

    public Tickets buyRandomTicketsUnderBudget(int budget) {
        Tickets newTickets = new Tickets();
        while (budget >= ticketPrice) {
            newTickets.add(agent.buyRandomTicket());
            investment += ticketPrice;
            budget -= ticketPrice;
        }
        tickets.add(newTickets);
        return newTickets;
    }

    public ReportDTO getReport() {
        return new ReportDTO(investment, tickets.getPrizeCount(agent));
    }
}
