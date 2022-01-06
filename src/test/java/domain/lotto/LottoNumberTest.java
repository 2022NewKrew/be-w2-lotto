package domain.lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class LottoNumberTest {

    @DisplayName("로또 6자리 숫자 제한 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 7})
    void lottoNumLimitTest(int lottoLen) {
        //given
        List<Number> numbers = new ArrayList<>();

        for (int i = 1; i <= lottoLen; i++) {
            numbers.add(new Number(i));
        }

        //when
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Lotto.makeOneInputLotto(numbers);
        });

        //then
        Assertions.assertEquals("로또는 6가지 숫자로 구성되어 있어야 합니다.", thrown.getMessage());
    }


}