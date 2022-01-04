package be.w2.lotto;

import be.w2.lotto.Domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyInitializeTest {

    @Test
    @DisplayName("Money_음수로_생성해서_실패하기")
    void test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(-1);
        });
    }
}
