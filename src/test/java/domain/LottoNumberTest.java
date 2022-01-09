package domain;

import exceptions.InvalidLastWeekWinningNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Test
    @DisplayName("[성공] LottoNumber 객체를 생성한다")
    void LottoNumber() {
        int number = 1;

        new LottoNumber(number);
    }

    @DisplayName("[실패] 범위를 벗어나는 숫자가 들어오면 InvalidLottoNumber를 던져야 한다")
    @ParameterizedTest(name = "{0} 들어오는 경우")
    @ValueSource(ints = {0, 46, -1})
    void LottoNumber_Failed_By_(int invalidNumber) {
        Assertions.assertThrows(InvalidLastWeekWinningNumber.class,
                () -> new LottoNumber(invalidNumber));
    }

    @Test
    @DisplayName("[성공] get 함수로 객체를 가져온다")
    void get() {
        int number = 1;

        LottoNumber lottoNumber = new LottoNumber(number);

        Assertions.assertEquals(number, lottoNumber.get());
    }
}