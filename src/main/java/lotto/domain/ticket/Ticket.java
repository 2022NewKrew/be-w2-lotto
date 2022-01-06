package lotto.domain.ticket;

import java.util.List;

public class Ticket {

    private final List<Integer> numberList;

    public Ticket(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public String printNumberList() {
        return numberList.toString();
    }

    public int countMatchingNumber(Ticket ticket) {
        return (int) numberList.stream().filter(ticket.numberList::contains).count();
    }

    public boolean has(int number) {
        return numberList.contains(number);
    }
}
