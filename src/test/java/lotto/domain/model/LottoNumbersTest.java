package lotto.domain.model;

import lotto.domain.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {
    private final static int LOTTO_NUMBERS_SIZE = 6;

    @Test
    @DisplayName("생성된 로또의 번호는 총 6개가 되야한다.")
    void getRandomLottoNumbers_MakeRandomLottoNumbers_Return6() {
        // given
        // when
        List<Integer> lottoNumbers = LottoNumbers.getRandomLottoNumbers();

        // then
        assertThat(lottoNumbers).hasSize(LOTTO_NUMBERS_SIZE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2", "1, 2, 3", "1"})
    @DisplayName("당첨 로또의 숫자 개수가 6개 이하인 경우 예외가 발생해야한다.")
    void getWinningLottoNumbers_InvalidSize_ExceptionThrown(String winningLottoNumbers) {
        assertThatThrownBy(() -> LottoNumbers.getWinningLottoNumbers(winningLottoNumbers))
                .hasMessage(ExceptionMessage.ERROR_INVALID_SIZE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 1, 1, 1, 1", "1, 2, 3, 2, 4, 5", "1, 2, 3, 4, 5, 5"})
    @DisplayName("당첨 로또의 숫자 중 중복이 있다면 예외가 발생해야한다.")
    void getWinningLottoNumbers_NumberDuplicate_ExceptionThrown(String winningLottoNumbers) {
        assertThatThrownBy(() -> LottoNumbers.getWinningLottoNumbers(winningLottoNumbers))
                .hasMessage(ExceptionMessage.ERROR_DUPLICATE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0, 2, 3, 4, 5, 6", "1, 2, 3, 4, 46, 45", "-1, 1, 2, 3, 4, 5"})
    @DisplayName("당첨 로또의 숫자 범위가 1보다 작거나 45보다 클 경우 예외가 발생해야한다.")
    void getWinningLottoNumbers_InvalidNumber_ExceptionThrown(String winningLottoNumbers) {
        assertThatThrownBy(() -> LottoNumbers.getWinningLottoNumbers(winningLottoNumbers))
                .hasMessage(ExceptionMessage.ERROR_INVALID_NUMBER.getMessage());
    }
}