package be.w2.lotto;

import be.w2.lotto.Domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {

    @Test
    @DisplayName("Money_999원으로_생성해서_실패하기")
    void test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(999);
        });
    }

    @Test
    void amountTest() {
        Money money = new Money(14000);
        assertThrows(IllegalArgumentException.class, () -> {
            money.sub(-1, 0);
        });
    }


    @Test
    void priceTest() {
        Money money = new Money(14000);
        assertThrows(IllegalArgumentException.class, () -> {
            money.sub(1, -1);
        });
    }


    @Test
    void tooMuchSubTest() {
        Money money = new Money(14000);
        assertThrows(IllegalArgumentException.class, () -> {
            money.sub(15, 1000);
        });
    }

    @Test
    void autoSellAmountTest() {
        Money money = new Money(14000);
        money.sub(3, 1000);
        assertThat(money.calculateAmount(1000).getAmount()).isEqualTo(11);
    }
}
