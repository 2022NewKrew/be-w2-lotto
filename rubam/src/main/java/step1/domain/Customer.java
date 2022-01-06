package step1.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Customer {

    private final Money money;
    private final List<LotteryTicket> tickets = new ArrayList<>();
    private int spent;

    Customer(Money money) {
        this.money = money;
    }

    int buyTickets() {
        int ticketCount = money.getAmount() / LotteryMachine.getTicketPrice();

        spent = LotteryMachine.getTicketPrice() * ticketCount;
        money.useMoney(spent);
        for(int i=0; i<ticketCount; i++) {
            tickets.add(LotteryMachine.createLotteryTicket());
        }
        return ticketCount;
    }

    List<LotteryTicket> getAllTickets() {
        return Collections.unmodifiableList(tickets);
    }

    int getSpent() {
        return spent;
    }
}
