package lotto;

import lotto.domain.Money;
import lotto.domain.RandomTicketsGenerator;
import lotto.domain.TicketsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {

    @Test
    @DisplayName("0보다 적은 금액 입력 테스트")
    void lessThanZeroAmountTest() {
        // given
        int inputMoney = -1000;

        // then
        String errorMessage = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Money(inputMoney);
        }).getMessage();
        assertThat(errorMessage).isEqualTo("돈은 음수값을 가질 수 없습니다.");
    }

    @Test
    @DisplayName("구매개수가 음수일 때 테스트")
    void buyTicketTest1() {
        // given
        int inputMoney = 1000;
        int ticketCount = -1;
        TicketsGenerator ticketsGenerator = new RandomTicketsGenerator();
        Money money = new Money(inputMoney);

        // then
        String errorMessage = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            money.buyTickets(ticketsGenerator, ticketCount);
        }).getMessage();
        assertThat(errorMessage).isEqualTo("티켓 개수는 음수값을 가질 수 없습니다.");
    }

    @Test
    @DisplayName("구매개수가 구매 가능 개수보다 많을 때 테스트")
    void buyTicketTest2() {
        // given
        int inputMoney = 1000;
        int ticketCount = 2;
        TicketsGenerator ticketsGenerator = new RandomTicketsGenerator();
        Money money = new Money(inputMoney);

        // then
        String errorMessage = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            money.buyTickets(ticketsGenerator, ticketCount);
        }).getMessage();
        assertThat(errorMessage).isEqualTo("잔액이 부족합니다.");
    }
}
