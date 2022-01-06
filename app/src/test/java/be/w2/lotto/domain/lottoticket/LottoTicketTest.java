package be.w2.lotto.domain.lottoticket;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static be.w2.lotto.common.exception.ExceptionMessages.INVALID_LOTTO_TICKET_SIZE_EXCEPTION;
import static be.w2.lotto.common.exception.ExceptionMessages.NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    void validateLottoNumbers_입력_받은_숫자가_6_미만일_경우_객체_생성에_실패하고_에러를_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5);

        // when
        ThrowableAssert.ThrowingCallable actual = () -> LottoTicket.validateLottoNumbers(lottoNumbers);

        // then
        assertThatThrownBy(actual)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_TICKET_SIZE_EXCEPTION);
    }

    @Test
    void validateLottoNumbers_입력_받은_숫자가_중복일_경우_객체_생성에_실패하고_에러를_반환한다() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when
        ThrowableAssert.ThrowingCallable actual = () -> LottoTicket.validateLottoNumbers(lottoNumbers);

        // then
        assertThatThrownBy(actual)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION);
    }
}
