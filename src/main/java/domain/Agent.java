package domain;

import domain.lottery.NumbersFactory;
import domain.lottery.Result;
import domain.lottery.Ticket;

import java.util.List;

public class Agent {

    private final NumbersFactory numbersFactory;
    private Result result;

    public Agent() {
        numbersFactory = new NumbersFactory();
    }

    public Ticket buyRandomTicket() {
        return new Ticket(numbersFactory.getRandomNumbers());
    }

    public void setResult(List<Integer> numbers, int bonusBall) {
        this.result = new Result(numbersFactory.getValidatedNumbers(numbers), bonusBall);
    }

    public Prize getTicketPrize(Ticket ticket) {
        return Prize.getPrize(result, ticket);
    }
}
