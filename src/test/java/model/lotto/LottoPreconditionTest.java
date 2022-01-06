package model.lotto;

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
    void testLegalNumbers(List<Integer> legalLottoNumbers) {
        //Give
        //When
        //Then
        assertThatCode(() -> Lotto.getDefinedLotto(legalLottoNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("중복된 숫자들이 담긴 리스트를 가지고 LottoPrecondition.checkNumbers 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("duplicatedNumbers")
    void testDuplicateNumbers(List<Integer> illegalLottoNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> Lotto.getDefinedLotto(illegalLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자의 개수가 허용된 개수보다 작거나 큰 리스트를 가지고 LottoPrecondition.checkNumbers 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("outOfRangeNumbers")
    void testWrongLengthNumbers(List<Integer> illegalLottoNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> Lotto.getDefinedLotto(illegalLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> legalNumbers() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
    }

    static Stream<List<Integer>> duplicatedNumbers() {
        return Stream.of(
                Arrays.asList(1, 1, 3, 4, 5, 6),
                Arrays.asList(1, 1, 1, 4, 5, 6),
                Arrays.asList(1, 1, 1, 4, 4, 6),
                Arrays.asList(1, 1, 1, 4, 4, 4),
                Arrays.asList(1, 1, 3, 3, 5, 5)
        );
    }

    static Stream<List<Integer>> outOfRangeNumbers() {
        return Stream.of(
                null,
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );
    }
}
