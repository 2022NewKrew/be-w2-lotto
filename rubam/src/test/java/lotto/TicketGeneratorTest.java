package lotto;

import lotto.domain.DirectTicketsGenerator;
import lotto.domain.Ticket;
import lotto.domain.TicketsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TicketGeneratorTest {

    @Test
    @DisplayName("티켓 생성 테스트")
    void generateTicketsTest() {
        // given
        List<Integer> ticketNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> tickets = new ArrayList<>();
        tickets.add(ticketNumbers);

        // when
        TicketsGenerator ticketsGenerator = new DirectTicketsGenerator(tickets);
        List<Ticket> createdTickets = ticketsGenerator.generateTickets(tickets.size());
        Ticket ticket = new Ticket(ticketNumbers);

        // then
        ticket.getTicketNumbers().getTicketNumbers().forEach(ticketNumber -> {
            assertThat(createdTickets.get(0).getTicketNumbers().getTicketNumbers().contains(ticketNumber)).isEqualTo(true);
        });
    }
}
