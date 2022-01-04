package model.lotto;

import model.number.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoPrecondition 테스트")
class LottoPreconditionTest {

    @DisplayName("올바른 숫자들이 담긴 리스트를 가지고 LottoPrecondition.checkNumbers 메서드를 실행했을 때 예외를 던지지 않는다.")
    @ParameterizedTest
    @MethodSource("legalNumbers")
    void testLegalNumbers(List<Number> legalNumbers) {
        //Give
        //When
        //Then
        assertThatCode(() -> LottoPrecondition.checkNumbers(legalNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("올바르지 못한 숫자들이 담긴 리스트를 가지고 LottoPrecondition.checkNumbers 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("illegalNumbers")
    void testIllegalNumbers(List<Number> illegalNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> LottoPrecondition.checkNumbers(illegalNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Number>> legalNumbers() {
        return Stream.of(
                Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)),
                Arrays.asList(new Number(1), new Number(5), new Number(9), new Number(13), new Number(17), new Number(21))
        );
    }

    static Stream<List<Number>> illegalNumbers() {
        return Stream.of(
                Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5)),
                Arrays.asList(new Number(1), new Number(1), new Number(9), new Number(13), new Number(17), new Number(21))
        );
    }

}
