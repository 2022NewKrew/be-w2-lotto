package model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Lotto 테스트")
public class LottoTest {

    @DisplayName("테스트를 위한 Lotto 인스턴스가 2개를 가지고 countDuplicateNumberWith 메서드를 실행했을 때 기대값과 실제 값이 같다")
    @ParameterizedTest
    @MethodSource("getTestNumbers")
    void countDuplicateNumberWith(List<Integer> testList1, List<Integer> testList2, int expectedNumber) {
        //Give
        Lotto testLotto1 = Lotto.getDefinedLotto(testList1);
        Lotto testLotto2 = Lotto.getDefinedLotto(testList2);
        //When
        int result = testLotto1.contain(testLotto2);
        //Then
        assertThat(result)
                .isEqualTo(expectedNumber);
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
