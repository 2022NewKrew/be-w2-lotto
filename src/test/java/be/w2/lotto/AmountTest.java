package be.w2.lotto;

import be.w2.lotto.Domain.Amount;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AmountTest {
    @Test
    void amountInitFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Amount(-1);
        });
    }

    @Test
    void manualInitNullFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            Amount amount = new Amount(1);
            amount.makeManualLottoTicket(null);
        });
    }

    @Test
    void ManualInitEmptyFail() {
        List<List<Integer>> testCase = new ArrayList<>();
        testCase.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> {
            Amount amount = new Amount(2);
            amount.makeManualLottoTicket(testCase);
        });
    }
}
