package org.cs.finn.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberFormatterTest {

    @ParameterizedTest
    @MethodSource("argsForNumberFormatter")
    @DisplayName("숫자를 입력하면 3개의 숫자마다 콤마를 넣어서 문자열로 반환한다")
    public void testNumberFormatter(int number, String expected) {
        assertThat(NumberFormatter.strNumberWithSeparator(number))
                .isEqualTo(expected);
    }

    public static Stream<Arguments> argsForNumberFormatter() {
        return Stream.of(
                Arguments.of(0, "0"),
                Arguments.of(100_000, "100,000"),
                Arguments.of(-38_792_835, "-38,792,835")
        );
    }
}
