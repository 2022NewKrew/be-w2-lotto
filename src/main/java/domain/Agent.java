package domain;

import domain.lottery.NumbersFactory;
import domain.lottery.Result;
import domain.lottery.Ticket;

import java.util.List;

public class Agent {
    private final static int DEFAULT_TICKET_PRICE = 1000;

    private final int ticketPrice;
    private final NumbersFactory numbersFactory;
    private Result result;

    public Agent() {
        ticketPrice = DEFAULT_TICKET_PRICE;
        numbersFactory = new NumbersFactory();
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public Ticket buyRandomTicket() {
        return new Ticket(numbersFactory);
    }

    public void setResult(List<Integer> numbers, int bonusBall) {
        this.result = new Result(numbers, numbersFactory, bonusBall);
    }

    public Prize getTicketPrize(Ticket ticket) {
        return Prize.getPrize(result, ticket);
    }
}
