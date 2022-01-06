package be.w2.lotto.domain.lottoticket;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static be.w2.lotto.common.exception.ExceptionMessages.INVALID_LOTTO_TICKET_SIZE_EXCEPTION;
import static be.w2.lotto.common.exception.ExceptionMessages.NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTicketTest {

    @Test
    void valueOf_객체_생성에_성공하고_WinningLottoTicket_객체를_반환한다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Class<WinningLottoTicket> expected = WinningLottoTicket.class;

        // when
        WinningLottoTicket actual = WinningLottoTicket.valueOf(winningNumbers);

        // then
        assertThat(actual).isInstanceOf(expected);
    }

    @Test
    void valueOf_입력_받은_숫자가_6_미만일_경우_객체_생성에_실패하고_에러를_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5);

        // when
        ThrowableAssert.ThrowingCallable actual = () -> WinningLottoTicket.valueOf(lottoNumbers);

        // then
        assertThatThrownBy(actual)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_TICKET_SIZE_EXCEPTION);
    }

    @Test
    void valueOf_입력_받은_숫자가_중복일_경우_객체_생성에_실패하고_에러를_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when
        ThrowableAssert.ThrowingCallable actual = () -> WinningLottoTicket.valueOf(lottoNumbers);

        // then
        assertThatThrownBy(actual)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION);
    }

    @Test
    void contains_입력된_bonusNumber를_객체의_lottoNumbers가_포함하면_true를_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(lottoNumbers);
        int bonusNumber = 1;
        boolean expected = true;

        // when
        boolean actual = winningLottoTicket.contains(bonusNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void contains_입력된_bonusNumber를_객체의_lottoNumbers가_포함하지_않으면_false를_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(lottoNumbers);
        int bonusNumber = 7;
        boolean expected = false;

        // when
        boolean actual = winningLottoTicket.contains(bonusNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
