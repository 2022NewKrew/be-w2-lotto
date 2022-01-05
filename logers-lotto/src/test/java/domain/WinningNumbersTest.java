package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {

    @ParameterizedTest
    @DisplayName("당첨번호의 갯수와 로또번호의 갯수 다를 때 실패")
    @MethodSource("listThatNumOfEntryNotEqualTo6")
    public void testFailedWhenNumberOfWriteNumberDifferent(List<Integer> numbers){
        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6));
        Lotto lotto = new Lotto(numbers);

        //when
        //then
        assertThatThrownBy(() -> winningNumbers.getMatchedNumber(lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("갯수");
    }


    private static Stream<Arguments> listThatNumOfEntryNotEqualTo6(){
        return Stream.of(
                Arguments.of(List.of(1,2,3)),
                Arguments.of(List.of(1,2,3,4,5)),
                Arguments.of(List.of(1,2,3,4,5,6,7))
        );
    }
}