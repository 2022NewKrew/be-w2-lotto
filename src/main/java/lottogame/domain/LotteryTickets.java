package lottogame.domain;

import java.util.List;

public class LotteryTickets {
    List<LotteryTicket> tickets;

    LotteryTickets(List<LotteryTicket> tickets) {
        this.tickets = tickets;
    }

    public int getCount() {
        return tickets.size();
    }

    public List<LotteryTicket> getTickets() {
        return tickets;
    }
}
