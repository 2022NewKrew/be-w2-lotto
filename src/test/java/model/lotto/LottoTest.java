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
    void countDuplicateNumberWith(List<Integer> testList1, List<Integer> testList2, long expectedNumber) {
        //Give
        Lotto testLotto1 = new DefinedLotto(testList1);
        Lotto testLotto2 = new DefinedLotto(testList2);
        //When
        long result = testLotto1.countDuplicateNumberWith(testLotto2);
        //Then
        assertThat(result).isEqualTo(expectedNumber);
    }

    static Stream<Arguments> getTestNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7), 5L),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 6L)
        );
    }
}
