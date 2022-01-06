package be.w2.lotto;

import be.w2.lotto.Domain.Amount;
import be.w2.lotto.Domain.ManualTicketGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TicketGeneratorTest {

    @Test
    void manualTest() {
        assertThatThrownBy(()->{
            Amount amount = new Amount(3);
            List<List<Integer>> inputList = new ArrayList<>();
            for (int i = 0; i < 4; i++)
                inputList.add(Arrays.asList(1, 2, 3, 4, 5, 6));
            amount.makeLottoTicket(new ManualTicketGenerator(inputList, amount));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
