package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoNumberTest {

    @DisplayName("같은 숫자로 생성된 로또 넘버는 동일해야 한다.")
    @Test
    void isEqual() {
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            assertThat(new LottoNumber(i))
                    .as("check number : %d", i)
                    .isEqualTo(new LottoNumber(i));
        }
    }

    @DisplayName("로또 넘버를 생성할 때, " + LottoNumber.MIN_VALUE + " 보다 작은 숫자를 전달하면 에러가 발생한다.")
    @Test
    void createLottoNumberWithSmallNumber() {
        int number = 0;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
           LottoNumber lottoNumber = new LottoNumber(number);
        });
    }

    @DisplayName("로또 넘버를 생성할 때, " + LottoNumber.MAX_VALUE + " 보다 큰 숫자를 전달하면 에러가 발생한다.")
    @Test
    void createLottoNumberWithLargeNumber() {
        int number = 46;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(number);
        });
    }

}