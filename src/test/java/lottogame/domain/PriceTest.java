package lottogame.domain;

import lottogame.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PriceTest {

    @Test
    @DisplayName("구입금액은 0보다 커야합니다.")
    void throwExceptionWhenPriceUnderZero() {
        assertThatThrownBy(() -> {
            new Price(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.UNDER_MIN_PRICE.getErrorMessage());
    }

    @Test
    @DisplayName("구입금액이 부족합니다.")
    void throwExceptionCalculateAmount() {
        Price defaultPrice = new Price(1000);
        Price purchasedPrice = new Price(2999);

        assertThatThrownBy(() -> {
            purchasedPrice.calculateAmount(defaultPrice);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.INSUFFICIENT_PRICE.getErrorMessage());
    }
}