package lotto.domain;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


class LotteryGameTest {
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    static LotteryGame game;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outStream));
        Ticket ticketOne = new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6));
        Ticket ticketTwo = new Ticket(Arrays.asList(4, 5, 6, 7, 8, 9));
        List<Ticket> manualTickets = Arrays.asList(ticketOne, ticketTwo);

        game = new LotteryGame(manualTickets, manualTickets.size());
    }

    @Test
    void secondPrize() {
        List<Integer> winningNumber = Arrays.asList(2, 3, 4, 5, 6, 7);
        int bonusNumber = 1;
        WinningTicket winningTicket = new WinningTicket(winningNumber, bonusNumber);
        Map<Integer, Integer> gameResult = game.getResult(winningTicket);

        assertThat(gameResult.getOrDefault(1, 0)).isEqualTo(0);
        assertThat(gameResult.getOrDefault(2, 0)).isEqualTo(1);
        assertThat(gameResult.getOrDefault(3, 0)).isEqualTo(0);
        assertThat(gameResult.getOrDefault(4, 0)).isEqualTo(1);
        assertThat(gameResult.getOrDefault(5, 0)).isEqualTo(0);
    }

    @Test
    void firstPrize() {
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningTicket winningTicket = new WinningTicket(winningNumber, bonusNumber);
        Map<Integer, Integer> gameResult = game.getResult(winningTicket);

        assertThat(gameResult.getOrDefault(1, 0)).isEqualTo(1);
        assertThat(gameResult.getOrDefault(2, 0)).isEqualTo(0);
        assertThat(gameResult.getOrDefault(3, 0)).isEqualTo(0);
        assertThat(gameResult.getOrDefault(4, 0)).isEqualTo(0);
        assertThat(gameResult.getOrDefault(5, 0)).isEqualTo(1);
    }
}