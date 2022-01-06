package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomTicketsGenerator implements TicketsGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public RandomTicketsGenerator() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    @Override
    public List<Ticket> generateTickets(int count) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(lottoNumbers);
            List<Integer> randomNumbers = lottoNumbers.subList(0, 6);
            Collections.sort(randomNumbers);
            tickets.add(new Ticket(randomNumbers));
        }
        return tickets;
    }
}
