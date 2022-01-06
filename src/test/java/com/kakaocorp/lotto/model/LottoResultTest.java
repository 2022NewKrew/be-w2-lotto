package com.kakaocorp.lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("provideGetParameters")
    void get(int matches, boolean bonus, LottoResult expected) {
        LottoResult result = LottoResult.get(matches, bonus);

        assertEquals(expected, result);
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
