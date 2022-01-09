package lotto.domain;

import java.util.List;

public class Amount {

    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public Amount subtractAmount(Amount amount) {
        if (this.amount < amount.amount)
            throw new IllegalArgumentException();
        return new Amount(this.amount - amount.amount);
    }

    public List<Ticket> changeToTickets(TicketsGenerator ticketsGenerator) {
        return ticketsGenerator.generateTickets(amount);
    }

    public int getAmount() {
        return amount;
    }
}
