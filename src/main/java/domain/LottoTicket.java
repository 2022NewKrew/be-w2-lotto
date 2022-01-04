package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Integer> numbers = new ArrayList<>();

    LottoTicket() {
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> makeRandomLottoNumbers() {
        List<Integer> ticket = new ArrayList<>();
        Collections.shuffle(numbers);
        for (int i = 0; i < 6; i++) {
            ticket.add(numbers.get(i));
        }
        Collections.sort(ticket);
        return ticket;
    }
}