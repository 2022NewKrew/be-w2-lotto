package model.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("NumberPrecondition 테스트")
class NumberPreconditionTest {

    @DisplayName("로또 숫자 범위 밖의 숫자를 가지고 NumberPrecondition.checkNumber 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @MethodSource("illegalNumber")
    void testIllegalNumbers(int illegalNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> NumberPrecondition.checkNumber(illegalNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Integer> illegalNumber() {
        return Stream.of(
                0, -1, 46
        );
    }
}
