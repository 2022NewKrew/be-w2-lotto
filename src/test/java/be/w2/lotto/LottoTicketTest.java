package be.w2.lotto;

import be.w2.lotto.Domain.LottoTicket;
import be.w2.lotto.View.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTicketTest {
    UserInterface userInterface;

    @BeforeEach
    void setUp() {
        userInterface = new UserInterface();
    }

    @Test
    void manualDuplicateTest() {
        List<Integer> testCase = userInterface.stringToIntList("8, 8, 23, 41, 42, 43");
        assertThrows(IllegalArgumentException.class, () -> {
            LottoTicket.getInstanceByIntList(testCase);
        });
    }

    @Test
    void manualNormalTest() {
        List<Integer> testCase = userInterface.stringToIntList("8, 21, 23, 41, 42, 43");
        LottoTicket.getInstanceByIntList(testCase);
    }

    @Test
    void ticketGreaterSizeFailTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoTicket.getInstanceByIntList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        });
    }

    @Test
    void ticketLessSizeFailTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoTicket.getInstanceByIntList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        });
    }
}
