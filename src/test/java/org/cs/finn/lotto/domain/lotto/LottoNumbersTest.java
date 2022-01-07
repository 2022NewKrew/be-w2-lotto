package org.cs.finn.lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("생성자에 null이 전달되면 예외를 발생시킨다")
    public void testConstructorNullFailure() {
        assertThatThrownBy(() -> new LottoNumbers((List<LottoNumber>) null))
                .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> new LottoNumbers((String[]) null))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @MethodSource("argsForDuplicateLottoNumber")
    @DisplayName("중복된 LottoNumber가 번호 목록에 존재하면 예외를 발생시킨다")
    public void testDuplicateLottoNumber(List<Integer> numbers) {
        // given
        List<LottoNumber> list = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        String[] array = numbers.stream()
                .map(String::valueOf)
                .toArray(String[]::new);

        // then
        assertThatThrownBy(() -> new LottoNumbers(list))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumbers(array))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForDuplicateLottoNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(5, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(2, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 6, 2, 3, 4, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("argsForMismatchSize")
    @DisplayName("번호 목록에 LottoNumber 개수가 " + LottoNumbers.SIZE + "개가 아니면 예외를 발생시킨다")
    public void testMismatchSize(List<Integer> numbers) {
        // given
        List<LottoNumber> list = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        String[] array = numbers.stream()
                .map(String::valueOf)
                .toArray(String[]::new);

        // then
        assertThatThrownBy(() -> new LottoNumbers(list))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumbers(array))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> argsForMismatchSize() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 7, 10, 12, 15)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7, 10)),
                Arguments.of(List.of(5, 1, 2, 3, 4)),
                Arguments.of(List.of(2, 1, 3, 5)),
                Arguments.of(List.of(1, 6, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("argsForUnorderedList")
    @DisplayName("정렬되지 않은 번호 목록을 넣으면 정렬 후 저장한다")
    public void testUnorderedList(List<Integer> numbers, List<LottoNumber> expected) {
        // given
        List<LottoNumber> list = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        String[] array = numbers.stream()
                .map(String::valueOf)
                .toArray(String[]::new);

        // then
        assertThat(new LottoNumbers(list).getList())
                .isEqualTo(expected);
        assertThat(new LottoNumbers(array).getList())
                .isEqualTo(expected);
    }

    public static Stream<Arguments> argsForUnorderedList() {
        final List<LottoNumber> expected = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            expected.add(new LottoNumber(i));
        }

        return Stream.of(
                Arguments.of(List.of(6, 1, 2, 3, 4, 5), expected),
                Arguments.of(List.of(5, 1, 2, 6, 4, 3), expected),
                Arguments.of(List.of(2, 4, 6, 3, 1, 5), expected),
                Arguments.of(List.of(1, 6, 2, 5, 4, 3), expected)
        );
    }
}
