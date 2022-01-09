package lotto;

import lotto.domain.Rank;
import lotto.domain.TicketNumber;
import lotto.domain.TicketNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("티켓 번호들을 비교하여 적절한 랭크를 반환한다.")
    void compareTicketNumbersTest() {
        // given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 8);
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 7, 8);
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 7, 8, 9);
        List<Integer> numbers6 = Arrays.asList(1, 2, 7, 8, 9, 10);

        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int inputBonusNumber = 7;

        // when
        TicketNumbers myTicketNumbers1 = new TicketNumbers(numbers1);
        TicketNumbers myTicketNumbers2 = new TicketNumbers(numbers2);
        TicketNumbers myTicketNumbers3 = new TicketNumbers(numbers3);
        TicketNumbers myTicketNumbers4 = new TicketNumbers(numbers4);
        TicketNumbers myTicketNumbers5 = new TicketNumbers(numbers5);
        TicketNumbers myTicketNumbers6 = new TicketNumbers(numbers6);

        TicketNumbers winTicketNumbers = new TicketNumbers(winNumbers);
        TicketNumber bonusNumber = new TicketNumber(inputBonusNumber);

        // then
        assertThat(myTicketNumbers1.compareTicket(winTicketNumbers, bonusNumber))
                .isEqualTo(Rank.FIRST);
        assertThat(myTicketNumbers2.compareTicket(winTicketNumbers, bonusNumber))
                .isEqualTo(Rank.SECOND);
        assertThat(myTicketNumbers3.compareTicket(winTicketNumbers, bonusNumber))
                .isEqualTo(Rank.THIRD);
        assertThat(myTicketNumbers4.compareTicket(winTicketNumbers, bonusNumber))
                .isEqualTo(Rank.FOURTH);
        assertThat(myTicketNumbers5.compareTicket(winTicketNumbers, bonusNumber))
                .isEqualTo(Rank.FIFTH);
        assertThat(myTicketNumbers6.compareTicket(winTicketNumbers, bonusNumber))
                .isEqualTo(null);
    }
}
