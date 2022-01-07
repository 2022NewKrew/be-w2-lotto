package org.cs.finn.lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @MethodSource("argsForConstructorStringInvalid")
    @DisplayName("String 생성자에 null, 빈 값, 숫자가 아닌 문자열, 사이에 공백이 들어간 숫자 및 음수가 전달되면 예외를 발생시킨다")
    public void testConstructorStringInvalid(String str) {
        assertThatThrownBy(() -> new LottoNumber(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForConstructorStringInvalid() {
        return Stream.of(
                Arguments.of((String)null),
                Arguments.of(""),
                Arguments.of("  "),
                Arguments.of(" \r  \n \t "),
                Arguments.of("dlkfjle"),
                Arguments.of(" lksjie   "),
                Arguments.of(" 34 6342 "),
                Arguments.of("3 6"),
                Arguments.of(" -34   "),
                Arguments.of("-1")
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorStringOutOfBound")
    @DisplayName("String 생성자에 " + LottoNumber.MIN + "보다 작고 0 이상인 수 또는 " + LottoNumber.MAX + "보다 큰 수가 쓰인 문자열이 전달되면 예외를 발생시킨다")
    public void testConstructorStringOutOfBound(String str) {
        assertThatThrownBy(() -> new LottoNumber(str))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    public static Stream<Arguments> argsForConstructorStringOutOfBound() {
        return Stream.of(
                Arguments.of("0"),
                Arguments.of("46"),
                Arguments.of("234524")
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorIntNegativeFailure")
    @DisplayName("int 생성자에 음수가 전달되면 예외를 발생시킨다")
    public void testConstructorIntNegativeFailure(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForConstructorIntNegativeFailure() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-2342),
                Arguments.of(Integer.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorIntOutOfBound")
    @DisplayName("int 생성자에 " + LottoNumber.MIN + "보다 작고 0 이상인 수 또는 " + LottoNumber.MAX + "보다 큰 수가 쓰인 문자열이 전달되면 예외를 발생시킨다")
    public void testConstructorIntOutOfBound(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    public static Stream<Arguments> argsForConstructorIntOutOfBound() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(46),
                Arguments.of(23523623),
                Arguments.of(Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorSuccess")
    @DisplayName("String 또는 int 생성자에 [" + LottoNumber.MIN + ", " + LottoNumber.MAX + "] 범위의 수가 전달되면 정상적으로 인스턴스를 생성한다")
    public void testConstructorSuccess(int number) {
        assertThatNoException().isThrownBy(() ->
                assertThat(new LottoNumber(String.valueOf(number)).get())
                        .isEqualTo(number)
        );
        assertThatNoException().isThrownBy(() ->
                assertThat(new LottoNumber(number).get())
                        .isEqualTo(number)
        );
    }

    public static Stream<Arguments> argsForConstructorSuccess() {
        return Stream.of(
                Arguments.of(LottoNumber.MIN),
                Arguments.of(LottoNumber.MAX),
                Arguments.of(36),
                Arguments.of(13),
                Arguments.of(43)
        );
    }
}
