package be.w2.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static be.w2.lotto.common.exception.ExceptionMessages.BONUS_NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BonusNumberTest {
    int bonusNumberInput;

    @BeforeEach
    void setUp() {
        bonusNumberInput = 1;
    }

    @Test
    void valueOf_객체_생성에_성공하고_BonusNumber_객체를_반환한다() {
        // given
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(List.of(2, 3, 4, 5, 6, 7));;

        // when
        BonusNumber bonusNumber = BonusNumber.valueOf(bonusNumberInput, winningLottoTicket);

        // then
        assertThat(bonusNumber).isInstanceOf(BonusNumber.class);
    }

    @Test
    void valueOf_중복된_bonusNumber의_경우_객체_생성에_실패하고_에러를_throw한다() {
        // given
        WinningLottoTicket duplicatedLottoTicket = WinningLottoTicket.valueOf(List.of(1, 2, 3, 4, 5, 6));

        // when - then
        assertThatThrownBy(() -> BonusNumber.valueOf(bonusNumberInput, duplicatedLottoTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION);
    }

    @Test
    void isContainedIn_입력된_listedTicket_가_객체의_number를_포함하고_있으면_true를_반환한다() {
        // given
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(List.of(2, 3, 4, 5, 6, 7));;
        BonusNumber bonusNumber = BonusNumber.valueOf(bonusNumberInput, winningLottoTicket);
        List<Integer> listedTicket = List.of(1, 2, 3, 4, 5, 6);

        // when
        boolean containsBonusNumber = bonusNumber.isContainedIn(listedTicket);

        // then
        assertThat(containsBonusNumber).isEqualTo(true);
    }

    @Test
    void isContainedIn_입력된_listedTicket_가_객체의_number를_포함하지_않으면_false를_반환한다() {
        // given
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(List.of(2, 3, 4, 5, 6, 7));;
        BonusNumber bonusNumber = BonusNumber.valueOf(bonusNumberInput, winningLottoTicket);
        List<Integer> listedTicket = List.of(2, 3, 4, 5, 6, 7);

        // when
        boolean containsBonusNumber = bonusNumber.isContainedIn(listedTicket);

        // then
        assertThat(containsBonusNumber).isEqualTo(false);
    }
}
