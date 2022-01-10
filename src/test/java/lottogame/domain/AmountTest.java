package lottogame.domain;

import lottogame.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AmountTest {

    @Test
    @DisplayName("구입개수는 0보다 작을 수 없습니다.")
    void throwExceptionInsufficientAmount() {
        assertThatThrownBy(() -> {
            new Amount(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.UNDER_MIN_AMOUNT.getErrorMessage());
    }

    @Test
    @DisplayName("구입개수에 따른 티켓 생성 개수 확인")
    void checkCountOfLotteryTickets() {
        int amount = 10;
        LotteryTickets tickets = new Amount(amount).buyLotteryTickets(new RandomGenerator());

        assertThat(tickets.getLotteryTickets().size()).isEqualTo(amount);
    }

    @Test
    @DisplayName("구입개수 빼기 계산 확인")
    void checkSubtractAmount() {
        int a = 10;
        int b = 4;

        Amount amountA = new Amount(a);
        Amount amountB = new Amount(b);

        assertThat(amountA.subtract(amountB).getAmount()).isEqualTo(a - b);
    }
}