package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LotteryTest {

    Lottery lottery;

    @BeforeEach
    void setup() {
        Set<Integer> lotteryNumber = IntStream.rangeClosed(1,6)
                .boxed()
                .collect(Collectors.toSet());
        lottery = new Lottery(lotteryNumber);
    }

    @Test
    void calculateMatchCount_DrawnNumberListIsNull_ThrowsIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> lottery.calculateMatchCount(null))
                .withMessage("당첨 번호 목록 정보가 올바르지 않습니다.");
    }

    @Test
    void calculateMatchCount_DrawnNumberSizeNotEquals_ThrowsIllegalArgumentException() {
        Set<Integer> drawnNumber = IntStream.rangeClosed(1,10)
                .boxed()
                .collect(Collectors.toSet());
        assertThatIllegalArgumentException().isThrownBy(() -> lottery.calculateMatchCount(drawnNumber))
                .withMessage("당첨 번호 목록 정보가 올바르지 않습니다.");
    }

    @Test
    void calculateMatchCount_ValidParameter_ReturnsCorrectCount() {
        Set<Integer> drawnNumber = IntStream.rangeClosed(3,8)
                .boxed()
                .collect(Collectors.toSet());
        assertThat(lottery.calculateMatchCount(drawnNumber)).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void contains_ContainsTarget_ReturnsTrue(int target) {
        assertThat(lottery.contains(target)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {27,44,45})
    void contains_NotContainsTarget_ReturnsFalse(int target) {
        assertThat(lottery.contains(target)).isFalse();
    }
}
