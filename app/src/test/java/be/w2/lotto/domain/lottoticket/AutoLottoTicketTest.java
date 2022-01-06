package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.domain.lottonumber.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AutoLottoTicketTest {

    @Test
    void from_객체_생성에_성공하고_AutoLottoTicket_객체를_반환한다() {
        // given
        List<LottoNumber> lottoNumbers = List.of(LottoNumber.from(1), LottoNumber.from(2));
        Class<AutoLottoTicket> expected = AutoLottoTicket.class;

        // when
        AutoLottoTicket actual = AutoLottoTicket.from(lottoNumbers);

        // then
        assertThat(actual).isInstanceOf(expected);
    }
}
