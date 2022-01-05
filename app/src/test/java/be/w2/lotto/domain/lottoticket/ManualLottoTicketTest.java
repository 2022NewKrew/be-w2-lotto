package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.domain.lottonumber.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static be.w2.lotto.common.exception.ExceptionMessages.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ManualLottoTicketTest {

    @Test
    void valueOf_객체_생성에_성공하고_ManualLottoTicket_객체를_반환한다() {
        // given
        List<Integer> lottoNumbers = Stream.of(
                        LottoNumber.from(1), LottoNumber.from(2),
                        LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(6)
                )
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

        // when
        ManualLottoTicket manualLottoTicket = ManualLottoTicket.valueOf(lottoNumbers);

        // then
        assertThat(manualLottoTicket).isInstanceOf(ManualLottoTicket.class);
    }

    @Test
    void valueOf_입력_받은_숫자가_6_미만일_경우_객체_생성에_실패하고_에러를_반환한다() {
        // given
        List<Integer> lottoNumbers = Stream.of(LottoNumber.from(1), LottoNumber.from(2))
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

        // when - then
        assertThatThrownBy(() -> ManualLottoTicket.valueOf(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_TICKET_SIZE_EXCEPTION);
    }

    @Test
    void valueOf_입력_받은_숫자가_중복일_경우_객체_생성에_실패하고_에러를_반환한다() {
        // given
        List<Integer> lottoNumbers = Stream.of(
                        LottoNumber.from(1), LottoNumber.from(1),
                        LottoNumber.from(1), LottoNumber.from(1),
                        LottoNumber.from(1), LottoNumber.from(1)
                )
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

        // when - then
        assertThatThrownBy(() -> ManualLottoTicket.valueOf(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION);
    }
}
