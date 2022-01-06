package lotto.domain.model;

import lotto.domain.message.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottosTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 1, 999, 10})
    @DisplayName("잘못된 금액입력시 예외가 발생해야한다.")
    void of_InvalidPrice_ExceptionThrown(int price) {
        assertThatThrownBy(() -> Lottos.from(price))
                .hasMessage(ExceptionMessage.ERROR_INVALID_PRICE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 4000, 5000, 10000})
    @DisplayName("주문한 금액에 맞는 개수의 로또가 구매되어야한다.")
    void getLottos_When_Price_Is_Given(int price) {
        // given
        int basicPrice = 1000;

        // when
        Lottos purchaseLotto = Lottos.from(price);

        // then
        Assertions.assertThat(purchaseLotto.getLottos()).hasSize(price / basicPrice);
    }
}