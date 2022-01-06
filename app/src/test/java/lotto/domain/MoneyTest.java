package lotto.domain;

import lotto.domain.lotto.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("1000원 미만이면 예외 발생 테스트")
    void moneyAmountTest() {
        Assertions.assertThatThrownBy(() -> new Money(990)).isInstanceOf(IllegalArgumentException.class);
    }
}
