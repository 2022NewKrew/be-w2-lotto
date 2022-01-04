package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseTest {

    @ParameterizedTest
    @ValueSource(ints = {-10000, -1287234})
    @DisplayName("구매 금액이 음수면 에러가 발생한다.")
    void test_PurchaseLotto_WhitNegativeInt(int money) {
        // given

        // when
        ThrowingCallable callable = () -> new LottoPurchase(money);

        // then
        assertThatThrownBy(callable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1000:1", "14000:14"}, delimiter = ':')
    @DisplayName("구매 금액을 천원 단위로 절삭한 만큼 로또를 구매한다.")
    void test_PurchaseLotto_WithCorrectTicketCount(int money, int expectedTicket) {
        // given

        // when
        LottoPurchase lottoPurchase = new LottoPurchase(money);
        int ticket = lottoPurchase.purchase();

        // then
        assertThat(ticket).isEqualTo(expectedTicket);
    }
}