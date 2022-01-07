package be.w2.lotto.domain.lottoticket;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static be.w2.lotto.common.exception.InvalidLottoTicketSizeException.INVALID_LOTTO_TICKET_SIZE_EXCEPTION;
import static be.w2.lotto.common.exception.LottoNumberDuplicationNotAllowedException.LOTTO_NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ManualLottoTicketTest {

    @Test
    void valueOf_객체_생성에_성공하고_ManualLottoTicket_객체를_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Class<ManualLottoTicket> expected = ManualLottoTicket.class;

        // when
        ManualLottoTicket actual = ManualLottoTicket.valueOf(lottoNumbers);

        // then
        assertThat(actual).isInstanceOf(expected);
    }

    @Test
    void valueOf_입력_받은_숫자가_6_미만일_경우_객체_생성에_실패하고_에러를_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5);

        // when
        ThrowableAssert.ThrowingCallable actual = () -> ManualLottoTicket.valueOf(lottoNumbers);

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
        ThrowableAssert.ThrowingCallable actual = () -> ManualLottoTicket.valueOf(lottoNumbers);

        // then
        assertThatThrownBy(actual)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION);
    }
}
