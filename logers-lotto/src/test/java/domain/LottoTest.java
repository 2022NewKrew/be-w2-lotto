package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @ParameterizedTest
    @DisplayName("로또 번호의 갯수가 맞지 않을 때 실패")
    @MethodSource("numbersThatSizeDifferent")
    public void failedWhenNumbersSizeDifferent(List<Integer> numbers){
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("갯수");
    }

    private static Stream<Arguments> numbersThatSizeDifferent(){
        return Stream.of(
                Arguments.of(List.of(1,2,3,4)),
                Arguments.of(List.of(1,2,3,4,5)),
                Arguments.of(List.of(1,2,3,4,5,6,7)),
                Arguments.of(List.of(1,2,3,4,5,6,7,8,9,10))
        );
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 1이상 45이하의 범위안의 숫자가 아닐때")
    @MethodSource("numbersThatHasWrongNumber")
    public void failedWhenNumbersThatHasWrongNumber(List<Integer> numbers){
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("번호");
    }

    private static Stream<Arguments> numbersThatHasWrongNumber(){
        return Stream.of(
                Arguments.of(List.of(-1, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10000))
        );
    }
}