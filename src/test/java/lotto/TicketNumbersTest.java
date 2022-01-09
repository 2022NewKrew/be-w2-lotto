package lotto;

import lotto.domain.TicketNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketNumbersTest {

    private final static String DUPLICATED_NUMBER_ERROR = "중복된 숫자가 있습니다.";
    private final static String NUMBERS_COUNT_ERROR = "숫자의 개수가 6개가 아닙니다.";

    @Test
    @DisplayName("티켓번호들은 중복이 없어야한다.")
    void duplicatedNumbersCheckTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // then
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TicketNumbers(numbers);
        });
        assertThat(e.getMessage()).isEqualTo(DUPLICATED_NUMBER_ERROR);
    }

    @Test
    @DisplayName("숫자의 개수가 6개보다 적을 경우")
    void numbersCountLessThanRequiredTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // then
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TicketNumbers(numbers);
        });
        assertThat(e.getMessage()).isEqualTo(NUMBERS_COUNT_ERROR);
    }

    @Test
    @DisplayName("숫자의 개수가 6개보다 많을 경우")
    void numbersCountMoreThanRequiredTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // then
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TicketNumbers(numbers);
        });
        assertThat(e.getMessage()).isEqualTo(NUMBERS_COUNT_ERROR);
    }
}
