package validate;

import domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;

class WinNumbersValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp(){
        validator = new WinNumbersValidator();
    }

    @ParameterizedTest
    @DisplayName("당첨 번호가 1이하의 범위라면 실패")
    @MethodSource("listHasNumberNotBetween1and45")
    void testFailedWhenWinnerNumbersNotBetween1and45(List<Integer> numbers){
        assertThatThrownBy(() -> validator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이상")
                .hasMessageContaining("이하");
    }

    private static Stream<Arguments> listHasNumberNotBetween1and45(){
        return Stream.of(
                Arguments.of(List.of(-1, 1, 22, 30, 44, 45)),
                Arguments.of(List.of(0, 1, 33, 45)),
                Arguments.of(List.of(1, 33, 45, 46))
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 번호의 갯수가 6개지 않으면 실패")
    @MethodSource("listSizeNotEqualTo6")
    void testFailedWhenListSizeNotEqualto6(List<Integer> numbers){
        assertThatThrownBy(() -> validator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("갯수");
    }


    private static Stream<Arguments> listSizeNotEqualTo6(){
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