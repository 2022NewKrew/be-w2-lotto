package lotto;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


class Ticket {
    private final List<Integer> ticketNumbers = new ArrayList<>();
    Random random = new Random();

    public Ticket() {
        createTicket();
    }

    private void createTicket() {
        while (ticketNumbers.size() <LotteryConstants.ticketLength) {
            int number = random.nextInt(LotteryConstants.maxNumber-1)+1;
            if (ticketNumbers.contains(number))
                continue;
            ticketNumbers.add(number);
        }
        Collections.sort(ticketNumbers);
    }

    public List<Integer> getTicketNumbers() {
        return this.ticketNumbers;
    }

}
