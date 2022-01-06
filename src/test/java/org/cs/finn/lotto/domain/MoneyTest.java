package org.cs.finn.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @MethodSource("argsForConstructorStringFailure")
    @DisplayName("String을 인수로 받는 생성자에 null, 빈 값, 숫자가 아닌 값 및 숫자 사이에 공백이 들어가면 예외를 발생한다")
    public void testConstructorStringFailure(String str) {
        assertThatThrownBy(() -> new Money(str))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    public static Stream<Arguments> argsForConstructorStringFailure() {
        return Stream.of(
                Arguments.of((Object)null),
                Arguments.of(""),
                Arguments.of("   "),
                Arguments.of(" \t \r \n   "),
                Arguments.of("test"),
                Arguments.of("thisisnot1234"),
                Arguments.of("  2342 2352  ")
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorStringSuccess")
    @DisplayName("String을 인수로 받는 생성자에 좌우 끝에 공백이 포함/미포함 된 숫자 문자열을 전달하면 정상적으로 인스턴스를 생성한다")
    public void testConstructorStringSuccess(String str) {
        assertThatNoException().isThrownBy(() -> System.out.println(new Money(str)));
    }

    public static Stream<Arguments> argsForConstructorStringSuccess() {
        return Stream.of(
                Arguments.of("20394"),
                Arguments.of("  1234"),
                Arguments.of("123   "),
                Arguments.of(" \t\n394 \r\t  ")
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorIntFailure")
    @DisplayName("int를 인수로 받는 생성자에 음수가 전달되면 예외를 발생시킨다")
    public void testConstructorIntFailure(int money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForConstructorIntFailure() {
        return Stream.of(
                Arguments.of(-3234),
                Arguments.of(-1),
                Arguments.of(Integer.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorIntSuccess")
    @DisplayName("int를 인수로 받는 생성자에 0 또는 양수가 전달되면 정상젹으로 인스턴스를 생성한다")
    public void testConstructorIntSuccess(int money) {
        assertThatNoException().isThrownBy(() -> System.out.println(new Money(money)));
    }

    public static Stream<Arguments> argsForConstructorIntSuccess() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(209384),
                Arguments.of(Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorIntIntNegative")
    @DisplayName("money, used int 2개를 받는 생성자에 음수가 전달되면 예외를 발생시킨다")
    public void testConstructorIntIntNegative(int money, int used) {
        assertThatThrownBy(() -> new Money(money, used))
                .isInstanceOf(IllegalStateException.class);
    }

    public static Stream<Arguments> argsForConstructorIntIntNegative() {
        return Stream.of(
                Arguments.of(-1, 0),
                Arguments.of(0, -1),
                Arguments.of(-2382, 13523),
                Arguments.of(9834,-32835)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorUsedIsBiggerThenMoney")
    @DisplayName("money, used int 2개를 받는 생성자에서 used가 money보다 크면 예외를 발생시킨다")
    public void testConstructorUsedIsBiggerThenMoney(int money, int used) {
        assertThatThrownBy(() -> new Money(money, used))
                .isInstanceOf(IllegalStateException.class);
    }

    public static Stream<Arguments> argsForConstructorUsedIsBiggerThenMoney() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 2),
                Arguments.of(-30, -29),
                Arguments.of(1000, 50000)
        );
    }

    @ParameterizedTest
    @MethodSource("argsForConstructorIntIntSuccess")
    @DisplayName("money, used int 2개를 받는 생성자에서 둘 다 0 또는 양수이고 money가 used와 같거나 used보다 크면 정상적으로 인스턴스를 생성한다")
    public void testConstructorIntIntSuccess(int money, int used) {
        assertThatNoException().isThrownBy(() -> System.out.println(new Money(money, used)));
    }

    public static Stream<Arguments> argsForConstructorIntIntSuccess() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(29834, 8239)
        );
    }
}
