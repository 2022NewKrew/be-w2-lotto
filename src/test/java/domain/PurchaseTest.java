package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseTest {
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

        assertThat(purchaseableQuantity).isEqualTo(purchaseAmount / Purchase.ONE_LOTTO_PRICE);
        assertThat(nonPurchaseable)
                .containsOnly(0);
    }

    @DisplayName("구매 금액이 올바른지 검증")
    @Test
    void isCorrectPurchaseAmount() {
        assertDoesNotThrow(() -> new Purchase(14000, 4, 10));
        assertThrows(IllegalArgumentException.class, () -> new Purchase(14500, 4, 10));
        assertThrows(IllegalArgumentException.class, () -> new Purchase(-14000, 4, 10));
    }

    @DisplayName("구매 수량이 올바른지 검증")
    @Test
    void isCorrectPurchaseQuantity() {
        assertDoesNotThrow(() -> new Purchase(14000, 4, 10));
        assertThrows(IllegalArgumentException.class, () -> new Purchase(14000, -4, 10));
        assertThrows(IllegalArgumentException.class, () -> new Purchase(14000, 4, 4));
    }
}