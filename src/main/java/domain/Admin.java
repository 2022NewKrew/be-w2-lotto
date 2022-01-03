package domain;

import domain.lottery.Result;
import domain.lottery.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Admin {
    private enum PrizeRank {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        NONE;
    }
    private final static int DEFAULT_FIRST_PRIZE_VALUE = 2000000000;
    private final static int DEFAULT_SECOND_PRIZE_VALUE = 1500000;
    private final static int DEFAULT_THIRD_PRIZE_VALUE = 50000;
    private final static int DEFAULT_FOURTH_PRIZE_VALUE = 5000;
    private final static int DEFAULT_TICKET_PRICE = 1000;

    private HashMap<PrizeRank, Integer> prizeValues;
    private int ticketPrice;
    private Result result;

    public Admin() {
        prizeValues = new HashMap<>();
        prizeValues.put(PrizeRank.FIRST, DEFAULT_FIRST_PRIZE_VALUE);
        prizeValues.put(PrizeRank.SECOND, DEFAULT_SECOND_PRIZE_VALUE);
        prizeValues.put(PrizeRank.THIRD, DEFAULT_THIRD_PRIZE_VALUE);
        prizeValues.put(PrizeRank.FOURTH, DEFAULT_FOURTH_PRIZE_VALUE);
        ticketPrice = DEFAULT_TICKET_PRICE;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public Ticket buyRandomTicket(Random random) {
        return new Ticket(random);
    }

    public void setResult(List<Integer> numbers) {
        this.result = new Result(numbers);
    }

    public Report getReportFor(User user) {
        HashMap<PrizeRank, Integer> prizeCount = createInitializedPrizeCount();
        for (var ticket : user.getTickets()) {
            PrizeRank ticketPrizeRank = getTicketPrizeRank(ticket);;
            prizeCount.put(ticketPrizeRank, prizeCount.get(ticketPrizeRank) + 1);
        }
        return new Report(user.getInvestment(), prizeValues.get(PrizeRank.FIRST), prizeValues.get(PrizeRank.SECOND), prizeValues.get(PrizeRank.THIRD), prizeValues.get(PrizeRank.FOURTH), prizeCount.get(PrizeRank.FIRST), prizeCount.get(PrizeRank.SECOND), prizeCount.get(PrizeRank.THIRD), prizeCount.get(PrizeRank.FOURTH));
    }

    private HashMap<PrizeRank, Integer> createInitializedPrizeCount() {
        HashMap<PrizeRank, Integer> prizeCount = new HashMap<>();
        for (var prizeRank : PrizeRank.values()) {
            prizeCount.put(prizeRank, 0);
        }
        return prizeCount;
    }

    private PrizeRank getTicketPrizeRank(Ticket ticket) {
        switch(this.result.getMatchingCountOf(ticket)) {
            case 6: return PrizeRank.FIRST;
            case 5: return PrizeRank.SECOND;
            case 4: return PrizeRank.THIRD;
            case 3: return PrizeRank.FOURTH;
            default: return PrizeRank.NONE;
        }
    }
}
