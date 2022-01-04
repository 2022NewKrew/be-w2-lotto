package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-10000, -1287234, 0, 999})
    @DisplayName("구매 금액이 1000원 미만이면 에러가 발생한다.")
    void test_PurchaseLotto_WhitNotEnoughMoney(int money) {
        // given

        // when
        ThrowingCallable callable = () -> new LottoMoney(money);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14"}, delimiter = ':')
    @DisplayName("구매 금액을 천원 단위로 절삭한 만큼 로또를 구매한다.")
    void test_PurchaseLotto_WithCorrectTicketCount(int money, int expectedTicket) {
        // given
        LottoMoney lottoPurchase = new LottoMoney(money);

        // when
        int ticket = lottoPurchase.purchase();

        // then
        assertThat(ticket).isEqualTo(expectedTicket);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:3000:-70.00", "1000:10000:900.00", "10000:15121:51.21", "1000:0:-100.00"}, delimiter = ':')
    @DisplayName("구매 금액을 천원 단위로 절삭한 만큼 로또를 구매한다.")
    void test_Profit(int beforeMoney, int afterMoney, double expectedProfit) {
        // given
        LottoMoney lottoMoney = new LottoMoney(beforeMoney);

        // when
        BigDecimal profit = lottoMoney.profit(BigDecimal.valueOf(afterMoney));

        // then
        assertThat(profit.doubleValue()).isEqualTo(expectedProfit);
    }
}