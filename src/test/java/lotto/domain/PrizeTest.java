package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Prize.*;
import static lotto.domain.RandomLottoNumberGenerator.NUMBERS_TO_PICK;
import static org.assertj.core.api.Assertions.*;

class PrizeTest {

    @DisplayName("abc")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndExpectations")
    void of(int matchedCount, boolean bonusBallMatched, Prize expected) {
        assertThat(Prize.of(matchedCount, bonusBallMatched)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoNumbersAndExpectations() {
        return Stream.of(
                // without bonus
                Arguments.of(NUMBERS_TO_PICK, false, FIRST),
                Arguments.of(NUMBERS_TO_PICK-1, false, THIRD),
                Arguments.of(NUMBERS_TO_PICK-2, false, FOURTH),
                Arguments.of(NUMBERS_TO_PICK-3, false, FIFTH),
                Arguments.of(NUMBERS_TO_PICK-4, false, SIXTH),
                Arguments.of(NUMBERS_TO_PICK-5, false, SEVENTH),
                Arguments.of(0, false, NOTHING),

                // with bonus
                Arguments.of(NUMBERS_TO_PICK-1, true, SECOND),
                Arguments.of(NUMBERS_TO_PICK-2, true, FOURTH),
                Arguments.of(NUMBERS_TO_PICK-3, true, FIFTH),
                Arguments.of(NUMBERS_TO_PICK-4, true, SIXTH),
                Arguments.of(NUMBERS_TO_PICK-5, true, SEVENTH)
        );
    }
}