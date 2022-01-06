package domain.lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @DisplayName("로또 숫자 제한 (1~45) 테스트")
    @ValueSource(ints = {0, 46})
    void numberLimitTest(int number) {
        //given
        //when
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Number num = new Number(number);
        });

        //then
        Assertions.assertEquals("숫자가 로또 범위를 초과하였습니다.", thrown.getMessage());
    }

}