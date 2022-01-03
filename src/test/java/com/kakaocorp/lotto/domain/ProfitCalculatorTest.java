package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.model.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfitCalculatorTest {

    private ProfitCalculator subject;

    @BeforeEach
    void setUp() {
        subject = new ProfitCalculator();
    }

    @ParameterizedTest
    @MethodSource("provideCalculateParameters")
    void calculate(int payment, Map<LottoResult, Integer> results, float expected) {
        float result = subject.calculate(payment, results);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideCalculateParameters() {
        return Stream.of(
                Arguments.of(1000, Map.of(LottoResult.FOURTH, 1), 5f),
                Arguments.of(1000, Map.of(LottoResult.FIRST, 0), 0),
                Arguments.of(23450, Map.of(LottoResult.SECOND, 3), 191.89766f),
                Arguments.of(
                        2000000,
                        Map.of(
                                LottoResult.FOURTH, 1,
                                LottoResult.THIRD, 1
                        ),
                        0.0275f
                )
        );
    }
}
