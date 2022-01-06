package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Prize.*;
import static org.assertj.core.api.Assertions.*;

class PrizeTest {

    @DisplayName("번호 맞힌 개수, 보너스볼 맞힌 여부에 맞게 등수 계산 되는지 확인")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndExpectations")
    void of(int matchedCount, boolean bonusBallMatched, Prize expected) {
        assertThat(Prize.of(matchedCount, bonusBallMatched)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoNumbersAndExpectations() {
        return Stream.of(
                // without bonus
                Arguments.of(6, false, FIRST),
                Arguments.of(5, false, THIRD),
                Arguments.of(4, false, FOURTH),
                Arguments.of(3, false, FIFTH),
                Arguments.of(2, false, SIXTH),
                Arguments.of(1, false, SEVENTH),
                Arguments.of(0, false, NOTHING),

                // with bonus
                Arguments.of(5, true, SECOND),
                Arguments.of(4, true, FOURTH),
                Arguments.of(3, true, FIFTH),
                Arguments.of(2, true, SIXTH),
                Arguments.of(1, true, SEVENTH)
        );
    }
}
