package model.lotto;

import model.lotto.LottoPrecondition;
import model.number.NumberPrecondition;
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
    void testLegalNumbers(List<Integer> legalNumbers) {
        //Give
        //When
        //Then
        assertThatCode(() -> LottoPrecondition.checkNumbers(legalNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("올바르지 못한 숫자들이 담긴 리스트를 가지고 LottoPrecondition.checkNumbers 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("illegalNumbers")
    void testIllegalNumbers(List<Integer> illegalNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> LottoPrecondition.checkNumbers(illegalNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> legalNumbers() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 5, 7, 8, 14, 38)
        );
    }

    static Stream<List<Integer>> illegalNumbers() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 1, 2, 3, 4, 5)
        );
    }

}
