package lotto.domain.model;

import static lotto.domain.helper.LottoNumberHelper.convertNumbersToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private static final List<Integer> WINNING_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int DUPLICATE_BONUS_NUMBER = 1;
    private static final int NOT_DUPLICATE_BONUS_NUMBER = 7;

    private static final String DUPLICATE_ERROR_MESSAGE = "중복";

    @DisplayName("보너스 번호 중복 검증 테스트")
    @Test
    void ofTest() {
        // Given
        Lotto lotto = Lotto.from(convertNumbersToLottoNumbers(WINNING_LOTTO_NUMBERS));
        LottoNumber bonusNumber = LottoNumber.from(NOT_DUPLICATE_BONUS_NUMBER);

        // When
        assertDoesNotThrow(() -> WinningLotto.of(lotto, bonusNumber));

        // Then
    }

    @DisplayName("보너스 번호 중복 오류 검증 테스트")
    @Test
    void ofTest2() {
        // Given
        Lotto lotto = Lotto.from(convertNumbersToLottoNumbers(WINNING_LOTTO_NUMBERS));
        LottoNumber bonusNumber = LottoNumber.from(DUPLICATE_BONUS_NUMBER);

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> WinningLotto.of(lotto, bonusNumber));

        // Then
        assertThat(exception.getMessage())
            .contains(DUPLICATE_ERROR_MESSAGE);
    }
}