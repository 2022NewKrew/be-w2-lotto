package lotto.controller;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 게임 입력 유효성 테스트")
class LottoGameTest{

    @Test
    @DisplayName("로또 구매금액은 음수가 될 수 없다.")
    void validatePurchaseAmountTest(){
        //given
        int purchaseAmount = -1000;

        // when
        Throwable thrown = catchThrowable(() -> InputValidator.validateNumber(purchaseAmount));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 음수입니다.");
    }

    @Test
    @DisplayName("로또는 음수로 구매할 수 없다.")
    void validateNumberOfLotteryPaperTest(){
        //given
        int numberOfManualLotto = -2;

        // when
        Throwable thrown = catchThrowable(() -> InputValidator.validateNumber(numberOfManualLotto));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 음수입니다.");
    }

    @Test
    @DisplayName("구매금액 이상으로 수동 구매가 불가능하다.")
    void validateOverPurchaseTest(){
        //given
        int numberOfLotto = 1;
        int numberOfManualLotto = 5;

        // when
        Throwable thrown = catchThrowable(() -> InputValidator.validateCanPurchaseLotto(numberOfLotto, numberOfManualLotto));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("장만 구매가 가능합니다.");
    }
}