package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest {
    private final int ONE_LOTTO_PRICE = 1000;

    @DisplayName("구매 가능 수량이 정상적으로 반환되는지 검증")
    @Test
    void isCorrectPurchaseableQuantity() {
        int purchaseAmount = 5000;
        int indivisibleAmount = 5500;
        int negativeAmount = -5000;

        int purchaseableQuantity = Purchase.purchaseableQuantity(purchaseAmount);
        List<Integer> nonPurchaseable = List.of(
                Purchase.purchaseableQuantity(indivisibleAmount),
                Purchase.purchaseableQuantity(negativeAmount)
        );

        assertThat(purchaseableQuantity).isEqualTo(purchaseAmount / ONE_LOTTO_PRICE);
        assertThat(nonPurchaseable)
                .containsOnly(0);
    }
}