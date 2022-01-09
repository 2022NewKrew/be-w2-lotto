package lotto;

import lotto.domain.TicketNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketNumberTest {

    @Test
    @DisplayName("1보다 작은 숫자 입력 테스트")
    void validateNumberTest1() {
        // given
        int inputNumber = 0;

        // then
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TicketNumber(inputNumber);
        });
        assertThat(e.getMessage()).isEqualTo("1~45 사이의 범위를 벗어났습니다.");
    }

    @Test
    @DisplayName("45보다 큰 숫자 입력 테스트")
    void validateNumberTest2() {
        // given
        int inputNumber = 46;

        // then
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TicketNumber(inputNumber);
        });
        assertThat(e.getMessage()).isEqualTo("1~45 사이의 범위를 벗어났습니다.");
    }

    @Test
    @DisplayName("두 숫자를 비교 테스트")
    void compareTicketNumber() {
        // given
        int inputNumber1 = 1;
        int inputNumber2 = 2;

        // when
        TicketNumber number1 = new TicketNumber(inputNumber1);
        TicketNumber number2 = new TicketNumber(inputNumber2);
        TicketNumber number3 = new TicketNumber(inputNumber1);

        // then
        assertThat(number1).isNotEqualTo(number2);
        assertThat(number1).isEqualTo(number3);
    }
}
