package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LotteryTicketTest {

    @Test
    @DisplayName("로또티켓 인자로 null을 사용할 수 없습니다.")
    void throwExceptionNumbersIsNull() {
        Throwable thrown = catchThrowable(() -> {
            new LotteryTicket(null);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또티켓 인자로 null을 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("")
    void throwException() {

    }
}