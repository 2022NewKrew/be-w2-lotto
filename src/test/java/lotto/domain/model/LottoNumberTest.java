package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    private static final String RANGE_ERROR_MESSAGE = "범위";

    @ParameterizedTest
    @ValueSource(ints = {1, 8, 15, 30, 38, 45})
    void fromTest(int number) {
        // Given

        // When
        assertDoesNotThrow(() -> LottoNumber.from(number));

        // Then
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void fromTest2(int number) {
        // Given

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> LottoNumber.from(number));

        // Then
        assertThat(exception.getMessage())
            .contains(RANGE_ERROR_MESSAGE);
    }
}