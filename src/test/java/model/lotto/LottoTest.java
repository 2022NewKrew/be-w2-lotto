package model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Lotto 테스트")
public class LottoTest {

    @DisplayName("올바른 숫자들이 담긴 리스트를 가지고 Lotto.getDefinedLotto 메서드를 실행했을 때 예외를 던지지 않는다.")
    @ParameterizedTest
    @MethodSource("legalNumbers")
    void testConstructorByLegalNumbers(List<Integer> legalLottoNumbers) {
        //Give
        //When
        //Then
        assertThatCode(() -> new Lotto(DefinedLottoGenerator.generate(legalLottoNumbers)))
                .doesNotThrowAnyException();
    }

    @DisplayName("중복된 숫자들이 담긴 리스트를 가지고 Lotto.getDefinedLotto 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("duplicatedNumbers")
    void testConstructorByDuplicateNumbers(List<Integer> illegalLottoNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> new Lotto(DefinedLottoGenerator.generate(illegalLottoNumbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자의 개수가 허용된 개수보다 작거나 큰 리스트를 가지고 Lotto.getDefinedLotto 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("outOfRangeNumbers")
    void testConstructorByWrongLengthNumbers(List<Integer> illegalLottoNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> new Lotto(DefinedLottoGenerator.generate(illegalLottoNumbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자의 개수가 허용된 개수보다 작거나 큰 리스트를 가지고 Lotto.getDefinedLotto 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @Test
    void testConstructorForRandomLotto() {
        //Give
        //When
        //Then
        assertThatCode(() -> new Lotto(RandomLottoGenerator.generate()))
                .doesNotThrowAnyException();
    }

    @DisplayName("테스트를 위한 Lotto 인스턴스가 2개를 가지고 countDuplicateNumberWith 메서드를 실행했을 때 기대값과 실제 값이 같다")
    @ParameterizedTest
    @MethodSource("getTestNumbers")
    void countDuplicateNumberWith(List<Integer> testList1, List<Integer> testList2, int expectedNumber) {
        //Give
        Lotto testLotto1 = new Lotto(DefinedLottoGenerator.generate(testList1));
        Lotto testLotto2 = new Lotto(DefinedLottoGenerator.generate(testList2));
        //When
        int result = testLotto1.contain(testLotto2);
        //Then
        assertThat(result)
                .isEqualTo(expectedNumber);
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

    static Stream<Arguments> getTestNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(7, 8, 9, 10, 11, 12), 0),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(6, 7, 8, 9, 10, 11), 1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 6)
        );
    }
}
