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
    void get(int matches, LottoResult expected) {
        LottoResult result = LottoResult.get(matches);

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

        List<LottoResult> expected = List.of(LottoResult.FIRST, LottoResult.SECOND, LottoResult.THIRD, LottoResult.FOURTH);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideToPrintStringParameters() {
        return Stream.of(
                Arguments.of(LottoResult.FIRST, 1, "6개 일치 (2000000000원)- 1개"),
                Arguments.of(LottoResult.SECOND, 4, "5개 일치 (1500000원)- 4개")
        );
    }

    private static Stream<Arguments> provideGetParameters() {
        return Stream.of(
                Arguments.of(6, LottoResult.FIRST),
                Arguments.of(5, LottoResult.SECOND),
                Arguments.of(4, LottoResult.THIRD),
                Arguments.of(3, LottoResult.FOURTH),
                Arguments.of(2, LottoResult.LOSE),
                Arguments.of(1, LottoResult.LOSE),
                Arguments.of(0, LottoResult.LOSE)
        );
    }
}
