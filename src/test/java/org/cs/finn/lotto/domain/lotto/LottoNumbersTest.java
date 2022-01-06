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

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @ParameterizedTest
    @MethodSource("argsForDuplicateLottoNumber")
    @DisplayName("중복된 LottoNumber가 List에 존재하면 예외를 발생시킨다")
    public void testDuplicateLottoNumber(List<Integer> numbers) {
        // given
        List<LottoNumber> list = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        // then
        assertThatThrownBy(() -> new LottoNumbers(list))
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

    @Test
    @DisplayName("List에 LottoNumber 개수가 " + LottoNumbers.SIZE +"개가 아니면 예외를 발생시킨다")
    public void testSizeInList() {
        // given
        List<LottoNumber> list = new ArrayList<>();
        list.add(new LottoNumber(1));
        list.add(new LottoNumber(2));
        list.add(new LottoNumber(3));
        list.add(new LottoNumber(4));
        list.add(new LottoNumber(5));

        // then
        assertThatThrownBy(() -> new LottoNumbers(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
