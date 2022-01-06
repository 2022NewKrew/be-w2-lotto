package lotto.domain;

import java.util.List;
import java.util.Map;

public class Money {

    private Integer amount;

    private static final String INPUT_MONEY_ERROR_MESSAGE = "돈은 음수값을 가질 수 없습니다.";
    private static final String INCORRECT_TICKET_COUNT_MESSAGE = "티켓 개수는 음수값을 가질 수 없습니다.";
    private static final String TOO_MUCH_TICKET_COUNT_MESSAGE = "잔액이 부족합니다.";

    public Money(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException(INPUT_MONEY_ERROR_MESSAGE);
        this.amount = amount;
    }

    public List<Ticket> buyTickets(TicketsGenerator ticketsGenerator, int count) {
        if (count < 0)
            throw new IllegalArgumentException(INCORRECT_TICKET_COUNT_MESSAGE);
        if (amount - (count * Ticket.TICKET_PRICE) < 0)
            throw new IllegalArgumentException(TOO_MUCH_TICKET_COUNT_MESSAGE);
        amount -= count * Ticket.TICKET_PRICE;
        return ticketsGenerator.generateTickets(count);
    }

    public List<Ticket> buyAllTickets(TicketsGenerator ticketsGenerator) {

        int count = amount / Ticket.TICKET_PRICE;
        return ticketsGenerator.generateTickets(count);
    }

    public static int calculateEarningRewardRate(Money spent, Map<Rank, Integer> results) {
        Money reward = new Money(0);
        results.forEach((rank, count) -> {
            reward.amount += rank.getReward() * count;
        });
        return (reward.amount - spent.amount) * 100 / spent.amount;
    }
}
