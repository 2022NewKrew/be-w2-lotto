package com.kakaocorp.lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("provideToPrintStringParameters")
    void toPrintString(LottoResult subject, int count, String expected) {
        String result = subject.toPrintString(count);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideGetParameters")
    void get(int matches, boolean bonus, LottoResult expected) {
        LottoResult result = LottoResult.get(matches, bonus);

        assertEquals(expected, result);
    }

    @Test
    void orderWinsByRankAsc_noLose() {
        List<LottoResult> result = LottoResult.orderWinsByRankAsc();

        assertFalse(result.contains(LottoResult.LOSE));
    }

    @Test
    void orderWinsByRankAsc_ordered() {
        List<LottoResult> result = LottoResult.orderWinsByRankAsc();

        List<LottoResult> expected = List.of(
                LottoResult.FIRST,
                LottoResult.SECOND,
                LottoResult.THIRD,
                LottoResult.FOURTH,
                LottoResult.FIFTH
        );
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideToPrintStringParameters() {
        return Stream.of(
                Arguments.of(LottoResult.FIRST, 1, "6개 일치 (2000000000원)- 1개"),
                Arguments.of(LottoResult.THIRD, 4, "5개 일치 (1500000원)- 4개")
        );
    }

    private static Stream<Arguments> provideGetParameters() {
        return Stream.of(
                Arguments.of(6, false, LottoResult.FIRST),
                Arguments.of(5, true, LottoResult.SECOND),
                Arguments.of(5, false, LottoResult.THIRD),
                Arguments.of(4, true, LottoResult.FOURTH),
                Arguments.of(3, false, LottoResult.FIFTH),
                Arguments.of(2, true, LottoResult.LOSE),
                Arguments.of(1, false, LottoResult.LOSE),
                Arguments.of(0, false, LottoResult.LOSE)
        );
    }
}
