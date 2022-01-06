package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountTest {

    @Test
    @DisplayName("구입금액은 0보다 커야합니다.")
    void throwExceptionWhenPriceUnderZero() {
        Throwable thrown = catchThrowable(() -> {
            new PurchaseAmount(0);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("구입금액은 0보다 커야합니다.");
    }

    @Test
    @DisplayName("구입금액이 부족합니다.")
    void throwExceptionInsufficientAmount() {
        Throwable thrown = catchThrowable(() -> {
            new PurchaseAmount(1001);
        });

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("구입금액이 부족합니다.");
    }

    @Test
    @DisplayName("구입금액에 따른 티켓 생성 개수 확인")
    void checkCountOfLotteryTickets() {
        int price = 14000;
        int defaultPrice = 1000;
        LotteryTickets tickets = new PurchaseAmount(price).buyLotteryTickets(new RandomGenerator());

        assertThat(tickets.getLotteryTickets().size()).isEqualTo(price / defaultPrice);
    }
}