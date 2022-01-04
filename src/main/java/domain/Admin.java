package domain;

import domain.lottery.NumbersFactory;
import domain.lottery.Result;
import domain.lottery.Ticket;

import java.util.EnumMap;
import java.util.List;

public class Admin {
    private final static int DEFAULT_TICKET_PRICE = 1000;

    private final int ticketPrice;
    private final NumbersFactory numbersFactory;
    private Result result;

    public Admin() {
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

    public Report getReportFor(User user) {
        EnumMap<Prize, Integer> prizeCount = createInitializedPrizeCount();
        for (var ticket : user.getTickets()) {
            Prize ticketPrize = Prize.getPrizeByMatchingCountAndIsBonusBallMatched(result.getMatchingCountOf(ticket), result.isBonusBallMatched(ticket));
            prizeCount.put(ticketPrize, prizeCount.get(ticketPrize) + 1);
        }
        return new Report(user.getInvestment(), prizeCount);
    }

    private EnumMap<Prize, Integer> createInitializedPrizeCount() {
        EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (var prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
        return prizeCount;
    }
}
