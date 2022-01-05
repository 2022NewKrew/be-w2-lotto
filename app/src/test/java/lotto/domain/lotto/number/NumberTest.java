package lotto.domain.lotto.number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    @DisplayName("숫자 범위 넘어가면 오류 내는 테스트")
    void numberRangeOverTest() {
        Assertions.assertThatThrownBy(() -> new Number(46)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Number(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 범위 넘지않으면 통과하는 테스트")
    void numberRangeTest() {
        Assertions.assertThatNoException().isThrownBy(() -> new Number(1));
    }
}
