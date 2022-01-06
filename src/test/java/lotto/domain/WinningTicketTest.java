package lotto.domain;


import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningTicketTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    void testValidArguments() {
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningTicket winningTicket  = new WinningTicket(winningNumber, bonusNumber);
        assertEquals(winningTicket.getTicketNumbers(), winningNumber);
        assertThat(winningTicket.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    void testOutOfBoundsWinningNumber() throws IllegalArgumentException {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,66);
        int bonusNumber = 7;
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> new WinningTicket(winningNumber, bonusNumber));
        assertThat(exception.getMessage()).isEqualTo("입력 숫자가 1이상 45이하여야 합니다.");
    }

    @Test
    void testOutOfBoundsBonusNumber() throws IllegalArgumentException {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 50;
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> new WinningTicket(winningNumber, bonusNumber));
        assertThat(exception.getMessage()).isEqualTo("입력 숫자가 1이상 45이하여야 합니다.");
    }

    @Test
    void testTooManyWinningNumbers() throws IllegalArgumentException {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6,7,8);
        int bonusNumber = 7;
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> new WinningTicket(winningNumber, bonusNumber));
        assertThat(exception.getMessage()).isEqualTo("입력한 복권 숫자 개수가 " + LotteryConstants.ticketLength + "개가 아닙니다.");
    }

    @Test
    void testBonusBallInWinningNumbers() throws  IllegalArgumentException {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 6;
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> new WinningTicket(winningNumber, bonusNumber));
        assertThat(exception.getMessage()).isEqualTo("보너스 볼의 숫자는 당첨 번호와 겹칠 수 없습니다.");
    }
}