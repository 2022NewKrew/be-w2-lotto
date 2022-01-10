package lottogame.domain;

import lottogame.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LotteryNumberTest {

    @Test
    @DisplayName("로또번호는 1이상 입니다.")
    void throwExceptionWhenUnderMinNumber() {
        assertThatThrownBy(() -> {
            new LotteryNumber(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.UNDER_MIN_LOTTERY_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("로또번호는 45이하 입니다.")
    void throwExceptionWhenOverMaxNumber() {
        assertThatThrownBy(() -> {
            new LotteryNumber(46);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.OVER_MAX_LOTTERY_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호 비교 테스트")
    void checkEqualLotteryNumber() {
        LotteryNumber a = new LotteryNumber(1);
        LotteryNumber b = new LotteryNumber(5);
        LotteryNumber c = new LotteryNumber(1);

        assertThat(a.equals(b)).isEqualTo(false);
        assertThat(a.equals(c)).isEqualTo(true);
    }
}