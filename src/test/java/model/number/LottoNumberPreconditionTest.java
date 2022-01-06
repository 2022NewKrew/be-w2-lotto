package model.number;

import model.lotto.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("NumberPrecondition 테스트")
class LottoNumberPreconditionTest {

    @DisplayName("로또 숫자 범위 밖의 숫자를 가지고 NumberPrecondition.checkNumber 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    void testIllegalNumbers(int illegalNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> new LottoNumber(illegalNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
