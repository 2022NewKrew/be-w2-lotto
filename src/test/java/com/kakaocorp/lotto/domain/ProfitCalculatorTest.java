package com.kakaocorp.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    void calculate(int payment, int gain, float expected) {
        float result = subject.calculate(payment, gain);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideCalculateParameters() {
        return Stream.of(
                Arguments.of(1000, 5000, 5f),
                Arguments.of(1000, 0, 0),
                Arguments.of(23450, 4500000, 191.89766f),
                Arguments.of(2000000, 55000, 0.0275f)
        );
    }
}
