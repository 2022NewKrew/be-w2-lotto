package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoMatchingResultTest {

    @DisplayName("로또 수익률 계산 테스트")
    @ParameterizedTest
    @MethodSource("provideOccurrencesAndExpects")
    void calculateEarningsRate(Map<Prize, Long> occurrences, float expected) {
        LottoMatchingResult lottoMatchingResult = new LottoMatchingResult(occurrences);
        assertThat(lottoMatchingResult.calculateEarningsRate()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOccurrencesAndExpects() {
        return Stream.of(
            Arguments.of(Map.of(Prize.NOTHING, 1L), -100f),
            Arguments.of(Map.of(Prize.FIFTH, 1L), 400f)
        );
    }

    @DisplayName("로또 당첨 횟수 테스트")
    @Test
    void calculateOccurrences() {
        LottoMatchingResult lottoMatchingResult = new LottoMatchingResult(Map.of(
            Prize.FIRST, 123L,
            Prize.SECOND, 456L
        ));

        assertThat(lottoMatchingResult.calculateOccurrences(Prize.FIRST)).isEqualTo(123L);
        assertThat(lottoMatchingResult.calculateOccurrences(Prize.SECOND)).isEqualTo(456L);
    }
}