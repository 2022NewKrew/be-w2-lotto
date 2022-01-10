package lottogame.domain;

import lottogame.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class WinningTicketTest {

    @Test
    @DisplayName("당첨 번호와 보너스 볼이 중복됩니다.")
    void throwExceptionWhenDuplicateNumbers() {
        assertThatThrownBy(() -> {
            new WinningTicket(
                    new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new LotteryNumber(6)
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.DUPLICATE_BONUS_BALL.getErrorMessage());
    }
}