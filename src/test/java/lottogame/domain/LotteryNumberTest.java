package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LotteryNumberTest {

    @Test
    @DisplayName("로또번호는 1이상 입니다.")
    void throwExceptionWhenUnderMinNumber() {
        Throwable thrown = catchThrowable(() -> {
            new LotteryNumber(0);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또번호는 1이상 입니다.");
    }

    @Test
    @DisplayName("로또번호는 45이하 입니다.")
    void throwExceptionWhenOverMaxNumber() {
        Throwable thrown = catchThrowable(() -> {
            new LotteryNumber(46);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또번호는 45이하 입니다.");
    }

    @Test
    @DisplayName("로또 번호가 같습니다.")
    void test() {

    }
}