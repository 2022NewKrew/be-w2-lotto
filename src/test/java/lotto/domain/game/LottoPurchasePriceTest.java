package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class LottoPurchasePriceTest {

    @DisplayName("숫자 천 단위 입력 검증 통과 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000})
    void validateTest(int price) {
        // Given

        // When
        assertDoesNotThrow(() -> LottoPurchasePrice.from(price));

        // Then
    }

    @DisplayName("숫자 천 단위 입력 검증 실패 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1100, 1219, 3228, 5001})
    void validateTest2(int price) {
        // Given

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> LottoPurchasePrice.from(price));

        // Then
        assertThat(exception.getMessage())
            .contains("로또 한 장의 가격은");
    }
}