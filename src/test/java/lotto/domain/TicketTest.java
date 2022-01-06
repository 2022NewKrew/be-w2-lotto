package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    void testValidArguments() {
        List<Integer> ticketNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket  = new Ticket(ticketNumber);
        assertEquals(ticket.getTicketNumbers(), ticketNumber);
    }

    @Test
    void testOutOfBoundsTicketNumber() throws IllegalArgumentException {
        List<Integer> ticketNumber = Arrays.asList(1,2,3,4,5,66);
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> new Ticket(ticketNumber));
        assertThat(exception.getMessage()).isEqualTo("입력 숫자가 1이상 45이하여야 합니다.");
    }

    @Test
    void testTooManyNumbers() throws IllegalArgumentException {
        List<Integer> ticketNumber = Arrays.asList(1,2,3,4,5,6,7,8);
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> new Ticket(ticketNumber));
        assertThat(exception.getMessage()).isEqualTo("입력한 복권 숫자 개수가 " + LotteryConstants.ticketLength + "개가 아닙니다.");
    }

}