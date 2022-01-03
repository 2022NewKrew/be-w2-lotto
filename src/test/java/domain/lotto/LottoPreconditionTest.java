package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoPreconditionTest {

    @DisplayName("올바른 숫자들이 담긴 리스트를 가지고 checkNumbers 메서드를 실행했을 때 예외를 던지지 않는다.")
    @ParameterizedTest
    @MethodSource("legalNumbers")
    void testLegalNumbers(List<Integer> legalNumbers) {
        //Give
        //When
        //Then
        assertThatCode(() -> LottoPrecondition.checkNumbers(legalNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("올바르지 못한 숫자들이 담긴 리스트를 가지고 checkNumbers 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("illegalNumbers")
    void testIllegalNumbers(List<Integer> legalNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> LottoPrecondition.checkNumbers(legalNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> legalNumbers() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
    }

    static Stream<List<Integer>> illegalNumbers() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 46, 5, 6),
                Arrays.asList(1, 1, 2, 3, 4, 5)
        );
    }

}
