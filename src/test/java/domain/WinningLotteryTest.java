package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLotteryTest {
    private final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    private final Lottery lottery = new Lottery(numbers);

    @DisplayName("보너스 볼의 범위가 올바른지 테스트")
    @Test
    void hasBonusNumberCorrectBound() {
        assertDoesNotThrow(() -> new WinningLottery(lottery, 25));
        assertThrows(IllegalArgumentException.class, () -> new WinningLottery(lottery, 50));
    }

    @DisplayName("보너스 볼이 기본 로또 번호와 중복되는지 테스트")
    @Test
    void isBonusNumberRepeated() {
        assertDoesNotThrow(() -> new WinningLottery(lottery, 7));
        assertThrows(IllegalArgumentException.class, () -> new WinningLottery(lottery, 6));
    }

}