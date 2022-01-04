package lottogame.domain.lottery;

import lottogame.dto.PurchasedPrice;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicketsFactory {
    private LotteryTicketsFactory() {
    }

    public static LotteryTickets create(PurchasedPrice purchasedPrice) {
        final int TICKET_PRICE = 1000;
        int numberOfTickets = (int) (purchasedPrice.getPrice() / TICKET_PRICE);

        List<LotteryTicket> tickets = new ArrayList<LotteryTicket>();
        for (int i = 0; i < numberOfTickets; i++) {
            LotteryTicket ticket = LotteryTicketFactory.create();
            tickets.add(ticket);
        }

        LotteryTickets lotteryTickets = new LotteryTickets(tickets);
        return lotteryTickets;
    }
}
