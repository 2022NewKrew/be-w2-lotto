package validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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
        assertThatThrownBy(()->validator.validate(numbers))
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
}