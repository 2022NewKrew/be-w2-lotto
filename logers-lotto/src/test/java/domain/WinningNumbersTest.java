package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {
    @ParameterizedTest
    @DisplayName("당첨 번호가 범위안의 숫자가 아닐때 실패")
    @MethodSource("numbersThatHasWrongNumber")
    void failedWhenNumbersHasWrongNumbers(List<Integer> numbers){
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이상")
                .hasMessageContaining("이하");
    }

    private static Stream<Arguments> numbersThatHasWrongNumber(){
        return Stream.of(
                Arguments.of(List.of(-1, 1, 22, 30, 44, 45)),
                Arguments.of(List.of(0, 1, 22, 30, 44, 45)),
                Arguments.of(List.of(1, 22, 30, 44, 45, 46))
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 번호의 갯수가 6개가 아니면 실패")
    @MethodSource("numbersThatSizeDifferent")
    void failedWhenNumbersSizeDifferent(List<Integer> numbers){
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("갯수");
    }

    private static Stream<Arguments> numbersThatSizeDifferent(){
        return Stream.of(
                Arguments.of(generateSameNumbers(Lotto.PRICE, 3)),
                Arguments.of(generateSameNumbers(Lotto.PRICE, 5)),
                Arguments.of(generateSameNumbers(Lotto.PRICE, 7)),
                Arguments.of(generateSameNumbers(Lotto.PRICE, 10))
        );
    }

    private static List<Integer> generateSameNumbers(int number, int times){
        return IntStream.iterate(number, num -> num)
                .boxed()
                .limit(times)
                .collect(toList());
    }
}