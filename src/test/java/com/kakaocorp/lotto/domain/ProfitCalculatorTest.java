package com.kakaocorp.lotto.domain;

import com.kakaocorp.lotto.validation.ValueNotAllowedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

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

    @Test
    void calculator_divideByZero() {
        Executable body = () -> subject.calculate(0, 1);

        assertThrowsExactly(ValueNotAllowedException.class, body);
    }

    private static Stream<Arguments> provideCalculateParameters() {
        return Stream.of(
                Arguments.of(1000, 5000, 4f),
                Arguments.of(1000, 0, -1.0f),
                Arguments.of(23450, 4500000, 190.89766f),
                Arguments.of(100, 30, -0.7f)
        );
    }
}
