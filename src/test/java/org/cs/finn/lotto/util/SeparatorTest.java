package org.cs.finn.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SeparatorTest {

    @ParameterizedTest
    @MethodSource("argsForNullArgs")
    @DisplayName("인자 중 하나라도 null이 전달되면 예외가 발생")
    public void testNullArgs(String str, String separator) {
        assertThatThrownBy(() -> Separator.splitString(str, separator))
                .isInstanceOf(NullPointerException.class);
    }

    public static Stream<Arguments> argsForNullArgs() {
        return Stream.of(
                Arguments.of(null, ","),
                Arguments.of("te,st", null)
        );
    }

    @Test
    @DisplayName("기본 구분자를 쓰는 경우와 기본 구분자를 명시적으로 전달한 결과가 동일해야한다")
    public void testDefaultSplitter() {
        // given
        String testTarget = "te,st";
        String separator = Separator.DEFAULT_SEPARATOR;

        // then
        assertThat(Separator.splitString(testTarget, separator))
                .isEqualTo(Separator.splitString(testTarget));
    }

    @Test
    @DisplayName("빈 값이 입력되는 경우 빈 값 1개가 든 배열을 반환한다")
    public void testEmptyInput() {
        // given
        String testTarget = "";

        // then
        assertThat(Separator.splitString(testTarget))
                .isEqualTo(new String[]{""});
    }

    @ParameterizedTest
    @MethodSource("argsForEmptyInput")
    @DisplayName("공백만 존재하는 빈 값이 입력된 경우 길이 0의 빈값이 1개 든 배열을 반환한다")
    public void testEmptyInput(String str, String[] expected) {
        assertThat(Separator.splitString(str))
                .isEqualTo(expected);
    }

    public static Stream<Arguments> argsForEmptyInput() {
        return Stream.of(
                Arguments.of("", new String[]{ "" }),
                Arguments.of("   ", new String[]{ "" })
        );
    }

    @ParameterizedTest
    @MethodSource("argsForOnlySeparator")
    @DisplayName("구분자만 또는 공백과 구분자만 입력되는 경우 길이 0의 빈값이 구분자 수 + 1개 든 배열을 반환한다")
    public void testOnlySeparator(String str, String[] expected) {
        assertThat(Separator.splitString(str))
                .isEqualTo(expected);
    }

    public static Stream<Arguments> argsForOnlySeparator() {
        return Stream.of(
                Arguments.of(",,", new String[]{ "", "", "" }),
                Arguments.of(" ,     ,   ,    ,     ", new String[]{ "", "", "", "", "" })
        );
    }

    @ParameterizedTest
    @MethodSource("argsForSuccess")
    @DisplayName("정상적인 입력 시 구분자로 구분된 문자열 배열을 반환한다")
    public void testSuccess(String str, String separator, String[] expected) {
        assertThat(Separator.splitString(str, separator))
                .isEqualTo(expected);
    }

    public static Stream<Arguments> argsForSuccess() {
        return Stream.of(
                Arguments.of("te,st", ",", new String[]{"te", "st"}),
                Arguments.of("t,  ,e, st  ", ",", new String[]{"t", "", "e", "st"}),
                Arguments.of(" ap ;pl ; e", ";", new String[]{"ap", "pl", "e"})
        );
    }
}
