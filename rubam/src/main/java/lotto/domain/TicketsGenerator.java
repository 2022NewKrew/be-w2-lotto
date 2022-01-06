package lotto.domain;

import java.util.List;

public interface TicketsGenerator {

    List<Ticket> generateTickets(int count);
}
