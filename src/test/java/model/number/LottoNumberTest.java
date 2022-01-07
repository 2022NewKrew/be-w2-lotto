package model.number;

import model.lotto.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("NumberPrecondition 테스트")
class LottoNumberTest {

    @DisplayName("로또 숫자 범위 밖의 숫자를 가지고 LottoNumber.valueOf 메서드를 실행했을 때 IllegalArgumentException 을 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    void testIllegalNumbers(int illegalNumbers) {
        //Give
        //When
        //Then
        assertThatThrownBy(() -> LottoNumber.valueOf(illegalNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자 범위 안의 숫자를 가지고 LottoNumber.valueOf 메서드를 실행했을 때 예외를 던지지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 32})
    void legalNumbers(int legalNumbers) {
        //Give
        //When
        //Then
        assertThatCode(() -> LottoNumber.valueOf(legalNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("Integer를 LottoNumber로 변환한 후 다시 Integer로 변환했을 때, 초기값과 변환값이 같다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void convertTest(int target) {
        LottoNumber lottoNumber = LottoNumber.valueOf(target);

        assertThat(LottoNumber.convertToInt(lottoNumber)).isEqualTo(target);
    }
}
