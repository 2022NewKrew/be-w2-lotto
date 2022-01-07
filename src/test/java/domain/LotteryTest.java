package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LotteryTest {

    @DisplayName("로또 번호가 6개인지 테스트")
    @Test
    void validateSize() {
        List<Integer> correctNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> incorrectNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertDoesNotThrow(() -> new Lottery(correctNumbers));
        assertThrows(IllegalArgumentException.class, () -> new Lottery(incorrectNumbers));
    }

    @DisplayName("로또 번호의 범위가 올바른지 테스트")
    @Test
    void validateNumberBound() {
        List<Integer> correctNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> incorrectNumbers = List.of(0, 1, 2, 3, 4, 5);

        assertDoesNotThrow(() -> new Lottery(correctNumbers));
        assertThrows(IllegalArgumentException.class, () -> new Lottery(incorrectNumbers));
    }

    @DisplayName("로또 번호에 중복이 있는지 테스트")
    @Test
    void validateNumbersRepeat() {
        List<Integer> correctNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> incorrectNumbers = List.of(1, 1, 2, 3, 4, 5);

        assertDoesNotThrow(() -> new Lottery(correctNumbers));
        assertThrows(IllegalArgumentException.class, () -> new Lottery(incorrectNumbers));
    }

}