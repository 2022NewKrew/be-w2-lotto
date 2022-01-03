package lotto.validator;

import static lotto.controller.LottoGame.TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.dto.LottoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameInputValidatorTest {

    LottoGameInputValidator lottoGameInputValidator;

    @BeforeEach
    void initTest() {
        lottoGameInputValidator = new LottoGameInputValidator();
    }

    @DisplayName("로또 구매금액 검증 테스트")
    @ParameterizedTest
    @ValueSource(ints = {200, 800, 3200, 12800, 15000})
    void purchasePriceValidate(int price) {
        int validatedPrice = lottoGameInputValidator.purchasePriceValidate(price);

        assertThat(validatedPrice % TICKET_PRICE)
            .isEqualTo(0);
    }

    @DisplayName("로또 당첨번호 검증 테스트")
    @Test
    void winningNumbersValidate() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() ->
            lottoGameInputValidator.winningNumbersValidate(new LottoDTO(winningNumbers)));
    }

    @DisplayName("로또 당첨번호 범위 오류 테스트")
    @Test
    void winningNumbersValidate2() {
        List<Integer> winningNumbers = List.of(0, 2, 4, 5, 6, 7);
        assertThrows(Exception.class,
            () -> lottoGameInputValidator.winningNumbersValidate(new LottoDTO(winningNumbers)));

        List<Integer> winningNumbers2 = List.of(1, 2, 3, 4, 5, 46);
        assertThrows(Exception.class,
            () -> lottoGameInputValidator.winningNumbersValidate(new LottoDTO(winningNumbers2)));
    }

    @DisplayName("로또 당첨번호 개수 오류 테스트")
    @Test
    void winningNumbersValidate3() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        assertThrows(Exception.class,
            () -> lottoGameInputValidator.winningNumbersValidate(new LottoDTO(winningNumbers)));
    }

    @DisplayName("로또 당첨번호 중복 테스트")
    @Test
    void winningNumbersValidate4() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        assertThrows(Exception.class,
            () -> lottoGameInputValidator.winningNumbersValidate(new LottoDTO(winningNumbers)));
    }
}
