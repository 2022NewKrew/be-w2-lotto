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
    @DisplayName("당첨 번호가 범위안의 숫자가 아닐때 실패")
    @MethodSource("inputThatHasWrongNumber")
    void failedWhenNumbersHasWrongNumbers(List<Integer> numbers, int bonusNumber){
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이상")
                .hasMessageContaining("이하");
    }

    // given
    private static Stream<Arguments> inputThatHasWrongNumber(){
        return Stream.of(
                Arguments.of(List.of(-1, 1, 22, 30, 44, 45), 31),
                Arguments.of(List.of(0, 1, 22, 30, 44, 45), 31),
                Arguments.of(List.of(1, 22, 30, 44, 45, 46), 31)
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 번호의 갯수가 6개가 아니면 실패")
    @MethodSource("inputThatHasSizeDifferent")
    void failedWhenNumbersSizeDifferent(List<Integer> numbers, int bonusNumber){
        assertThatThrownBy(() -> new WinningNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("갯수");
    }

    // given
    private static Stream<Arguments> inputThatHasSizeDifferent(){
        return Stream.of(
                Arguments.of(List.of(1,2,3,4), 45),
                Arguments.of(List.of(1,2,3,4,5), 45),
                Arguments.of(List.of(1,2,3,4,5,6,7), 45),
                Arguments.of(List.of(1,2,3,4,5,6,7,8,9,10), 45)
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 여부 성공 확인")
    @MethodSource("matchedMethodInputAndExpected")
    void successMatched(WinningNumbers winningNumbers, List<Integer> numbers, RewardType expected){
        assertThat(winningNumbers.matching(numbers)).isEqualTo(expected);
    }

    // given
    private static Stream<Arguments> matchedMethodInputAndExpected(){
        return Stream.of(
                Arguments.of(winningNumbers(), List.of(1,2,3,4,5,6), RewardType.FIRST_PLACE), // 1등
                Arguments.of(winningNumbers(), List.of(1,2,3,4,5,7), RewardType.SECOND_PLACE), // 2등
                Arguments.of(winningNumbers(), List.of(1,2,3,4,5,8), RewardType.THIRD_PLACE), // 3등
                Arguments.of(winningNumbers(), List.of(1,2,3,4,7,8), RewardType.FOURTH_PLACE), // 4등
                Arguments.of(winningNumbers(), List.of(1,2,3,7,8,9), RewardType.NONE) // 꽝
        );
    }

    private static WinningNumbers winningNumbers(){
        return new WinningNumbers(List.of(1,2,3,4,5,6), 7);
    }
}