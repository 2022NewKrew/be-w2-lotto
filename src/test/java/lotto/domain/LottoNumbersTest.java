package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

    @DisplayName("로또 넘버가 생성될 때, 숫자는 정렬된다.")
    @Test
    void sort() {
        List<Integer> numbers = List.of(1, 2, 5, 6, 3, 4);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
        assertThat(lottoNumbers.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 넘버가 포함되어 있으면 true를 반환한다.")
    @Test
    void containsTrue() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
        assertThat(lottoNumbers.contains(new LottoNumber(1))).isTrue();
    }

    @DisplayName("로또 넘버가 포함되어 있지 않으면 false를 반환하다.")
    @Test
    void containsFalse() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
        assertThat(lottoNumbers.contains(new LottoNumber(7))).isFalse();
    }

    @DisplayName("전달하는 로또 넘버 리스트에 해당하는 로또 넘버들이 생성된다.")
    @Test
    void createByNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = LottoNumbers.createByNumbers(numbers);

        for (int number : numbers) {
            assertThat(lottoNumbers.contains(new LottoNumber(number))).isTrue();
        }
    }

    @DisplayName("전달하는 로또 넘버 리스트의 크기가 6이 아니라면 에러가 발생한다.")
    @Test
    void createByNumbersWithLengthProblem() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumbers lottoNumbers = LottoNumbers.createByNumbers(numbers);
        });
    }

    @DisplayName("중복된 숫자를 포함하고 있으면 에러가 발생한다.")
    @Test
    void createLottoNumbersContainingDuplicatedNumbers() throws IllegalArgumentException {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumbers lottoNumbers = LottoNumbers.createByNumbers(numbers);
        });
    }

    @DisplayName("로또 넘버들과 일치하는 숫자 개수 확인 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    void countMatchNumberOfLottoNumbers(List<Integer> winningNumbers, int expectedEqualCount) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));

        LottoNumbers winningLottoNumbers = LottoNumbers.createByNumbers(winningNumbers);
        assertThat(lottoNumbers.countMatchNumberOfLottoNumbers(winningLottoNumbers)).isEqualTo(expectedEqualCount);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(List.of(1, 2, 30, 4, 5, 6), 5),
                Arguments.arguments(List.of(2, 3, 4, 5, 10, 45), 4),
                Arguments.arguments(List.of(3, 5, 6, 10, 20, 40), 3),
                Arguments.arguments(List.of(2, 6, 10, 11, 12, 13), 2),
                Arguments.arguments(List.of(6, 41, 42, 43, 44, 45), 1),
                Arguments.arguments(List.of(7, 8, 9, 10, 44, 45), 0)
        );
    }
}