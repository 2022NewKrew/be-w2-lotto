package lotto.domain.lotto.number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoTest {

    @Test
    @DisplayName("로또 숫자가 6이 되지 않는다면 오류 발생 테스트")
    void lottoNumberLengthOverTest() {
        Assertions.assertThatThrownBy(() -> Lotto.createLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자가 6이 된다면 통과하는 테스트")
    void lottoNumberLengthTest() {
        Assertions.assertThatNoException().isThrownBy(() -> Lotto.createLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
