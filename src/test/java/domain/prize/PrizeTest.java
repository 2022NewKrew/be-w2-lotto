package domain.prize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static domain.prize.Prize.*;

class PrizeTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("맞춘 숫자와 보너스 숫자 여부에 따라 보상이 주어진다")
    void testCreatePrizeWithMatchedNumAndMatchedBonus(int matchedNum, boolean matchedBonus, Prize prize) {
        //when
        Prize result = valueOf(matchedNum, matchedBonus);
        //then
        Assertions.assertThat(result).isEqualTo(prize);
    }

    private static Stream<Arguments> testCreatePrizeWithMatchedNumAndMatchedBonus() {
        return Stream.of(
                Arguments.of(6, false, FIRST_PRIZE),
                Arguments.of(5, true, SECOND_PRIZE),
                Arguments.of(5, false, THIRD_PRIZE),
                Arguments.of(4, true, FOURTH_PRIZE),
                Arguments.of(4, false, FOURTH_PRIZE),
                Arguments.of(3, true, FIFTH_PRIZE),
                Arguments.of(3, false, FIFTH_PRIZE),
                Arguments.of(2, true, NO_PRIZE),
                Arguments.of(2, false, NO_PRIZE),
                Arguments.of(1, true, NO_PRIZE),
                Arguments.of(1, false, NO_PRIZE),
                Arguments.of(0, true, NO_PRIZE),
                Arguments.of(0, false, NO_PRIZE)
        );
    }
}