package domain;

import domain.lottery.NumbersFactory;
import domain.lottery.Result;
import domain.lottery.Ticket;
import domain.lottery.Tickets;
import dto.ReportDTO;

import java.util.List;


public class Purchase {
    private final Tickets tickets;
    private int investment;
    private final int ticketPrice;
    private final NumbersFactory numbersFactory;
    private Result result;

    public Purchase(int ticketPrice) {
        this.ticketPrice = ticketPrice;
        this.numbersFactory = new NumbersFactory();
        investment = 0;
        tickets = new Tickets();
    }

    public Tickets buyRandomTicketsUnderBudget(int budget) {
        while (budget >= ticketPrice) {
            tickets.add(new Ticket(numbersFactory.getRandomNumbers()));
            investment += ticketPrice;
            budget -= ticketPrice;
        }
        return tickets;
    }

    public void setResult(List<Integer> numbers, int bonusBall) {
        this.result = new Result(numbersFactory.getValidatedNumbers(numbers), bonusBall);
    }

    public ReportDTO getReport() {
        return new ReportDTO(investment, tickets.getPrizeCount(result));
    }
}
