package org.cs.finn.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CheckerTest {

    @ParameterizedTest
    @MethodSource("argsForCheckIntBoundNegativeInteger")
    @DisplayName("IntBound - 음수가 전달되면 예외를 발생시킨다")
    public void testCheckIntBoundNegativeInteger(int val, int min, int max) {
        assertThatThrownBy(() -> Checker.checkIntBound(val, min, max))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForCheckIntBoundNegativeInteger() {
        return Stream.of(
                Arguments.of(-1, 1, 2),
                Arguments.of(2, -1, 2),
                Arguments.of(2, 1, -3)
        );
    }

    @Test
    @DisplayName("IntBound - min이 max보다 크면 예외를 발생시킨다")
    public void testCheckIntBoundMinIsBigDaddyOfMax() {
        // given
        final int val = 1;
        final int min = 3;
        final int max = 2;
        // then
        assertThatThrownBy(() -> Checker.checkIntBound(val, min, max))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @MethodSource("argsForCheckIntBoundOutsider")
    @DisplayName("IntBound - [min, max] 범위를 벗어난 값이 들어오면 예외를 발생시킨다")
    public void testCheckIntBoundOutsider(int val, int min, int max) {
        assertThatThrownBy(() -> Checker.checkIntBound(val, min, max))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    public static Stream<Arguments> argsForCheckIntBoundOutsider() {
        return Stream.of(
                Arguments.of(0, 10, 20),
                Arguments.of(30, 10, 20),
                Arguments.of(0, 1, 2),
                Arguments.of(3, 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForCheckIntBoundSuccess")
    @DisplayName("IntBound - [min, max] 범위 내 값이 들어오면 정상적으로 메서드를 종료한다")
    public void testCheckIntBoundSuccess(int val, int min, int max) {
        assertThatNoException().isThrownBy(() -> Checker.checkIntBound(val, min, max));
    }

    public static Stream<Arguments> argsForCheckIntBoundSuccess() {
        return Stream.of(
                Arguments.of(2, 1, 3),
                Arguments.of(5, 1, 9),
                Arguments.of(1, 0, 1),
                Arguments.of(0, 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForCheckIntNegativeWithZeroToFail")
    @DisplayName("Int - zeroToFail가 true인 경우 0 또는 음수가 들어오면 예외가 발생한다")
    public void testCheckIntNegativeWithZeroToFail(int val) {
        assertThatThrownBy(() -> Checker.checkInt(val, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForCheckIntNegativeWithZeroToFail() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(Integer.MIN_VALUE),
                Arguments.of(-2),
                Arguments.of(-1)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForCheckIntNegativeWithoutZeroToFail")
    @DisplayName("Int - zeroToFail가 false인 경우 음수가 들어오면 예외가 발생한다")
    public void testCheckIntNegativeWithoutZeroToFail(int val) {
        assertThatThrownBy(() -> Checker.checkInt(val, false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForCheckIntNegativeWithoutZeroToFail() {
        return Stream.of(
                Arguments.of(Integer.MIN_VALUE),
                Arguments.of(-2),
                Arguments.of(-1)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForCheckIntSuccessWithZeroToFail")
    @DisplayName("Int - zeroToFail가 true인 경우 양수가 들어올때만 정상적으로 메서드가 종료한다")
    public void testCheckIntSuccessWithZeroToFail(int val) {
        assertThatNoException().isThrownBy(() -> Checker.checkInt(val, true));
    }

    public static Stream<Arguments> argsForCheckIntSuccessWithZeroToFail() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE),
                Arguments.of(2),
                Arguments.of(1)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForCheckIntSuccessWithoutZeroToFail")
    @DisplayName("Int - zeroToFail가 false인 경우 0 또는 양수가 들어올때만 정상적으로 메서드가 종료한다")
    public void testCheckIntSuccessWithoutZeroToFail(int val) {
        assertThatNoException().isThrownBy(() -> Checker.checkInt(val, false));
    }

    public static Stream<Arguments> argsForCheckIntSuccessWithoutZeroToFail() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(Integer.MAX_VALUE),
                Arguments.of(2),
                Arguments.of(1)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForCheckIntMinMaxNegative")
    @DisplayName("IntMinMax - 음수가 전달되면 예외를 발생시킨다")
    public void testCheckIntMinMaxNegative(int min, int max) {
        assertThatThrownBy(() -> Checker.checkIntMinMax(min, max))
                .isInstanceOf(IllegalStateException.class);
    }

    public static Stream<Arguments> argsForCheckIntMinMaxNegative() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(1, -1)
        );
    }

    @Test
    @DisplayName("IntMinMax - min이 max보다 크면 예외를 발생시킨다")
    public void testCheckIntMinMaxMinIsBigDaddyOfMax() {
        // given
        final int min = 100_000;
        final int max = 100;
        // then
        assertThatThrownBy(() -> Checker.checkIntMinMax(min, max))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("IntMinMax - 음수 입력이 없고 min보다 max가 크면 메서드가 정상적으로 종료된다")
    public void testCheckIntMinMaxSuccess() {
        // given
        final int min = 100;
        final int max = 100_000;
        // then
        assertThatNoException().isThrownBy(() -> Checker.checkIntMinMax(min, max));
    }

    @ParameterizedTest
    @MethodSource("argsForCheckStringNullOrBlank")
    @DisplayName("String - null 또는 공백, newline, tab 문자들로만 구성된 값이 입력되면 예외를 발생시킨다")
    public void testCheckStringNullOrBlank(String str) {
        assertThatThrownBy(() -> Checker.checkString(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForCheckStringNullOrBlank() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of((Object)null),
                Arguments.of("  "),
                Arguments.of(" \t\r\n ")
        );
    }

    @Test
    @DisplayName("String - 빈 값을 제외한 문자열 값이 들어오면 메서드가 정상적으로 종료된다")
    public void testCheckStringSuccess() {
        // given
        final String str = "testForCheckString1234567890";
        // then
        assertThatNoException().isThrownBy(() -> Checker.checkString(str));
    }
}
