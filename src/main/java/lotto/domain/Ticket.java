package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Ticket {
    private final List<Integer> ticketNumbers = new ArrayList<>();
    Random random = new Random();

    public Ticket() {
        createTicket();
    }

    private void getUniqueNumber() {
        int number = random.nextInt(LotteryConstants.maxNumber-1)+1;
        if (!ticketNumbers.contains(number))
            ticketNumbers.add(number);
    }

    private void createTicket() {
        while (ticketNumbers.size() < LotteryConstants.ticketLength) {
            getUniqueNumber();
        }
        Collections.sort(ticketNumbers);
    }

    public List<Integer> getTicketNumbers() {
        return this.ticketNumbers;
    }

}
