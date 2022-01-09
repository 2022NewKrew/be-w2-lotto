package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {

    @Test
    @DisplayName("0보다 적은 금액 입력 테스트")
    void lessThanZeroAmountTest() {
        // given
        int inputMoney = -1000;

        // then
        String errorMessage = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Money(inputMoney);
        }).getMessage();
        assertThat(errorMessage).isEqualTo("돈은 음수값을 가질 수 없습니다.");
    }
}
