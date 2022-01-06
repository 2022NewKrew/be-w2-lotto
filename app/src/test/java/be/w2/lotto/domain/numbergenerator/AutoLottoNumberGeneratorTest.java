package be.w2.lotto.domain.numbergenerator;

import be.w2.lotto.domain.lottoticket.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static be.w2.lotto.domain.lottonumber.LottoNumber.LOTTO_NUMBER_LOWERBOUND;
import static be.w2.lotto.domain.lottonumber.LottoNumber.LOTTO_NUMBER_UPPERBOUND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AutoLottoNumberGeneratorTest {

    @Test
    void generateLottoTickets_자동으로_lottoTicket_객체_리스트를_생성하고_반환한다() {
        // given
        AutoLottoNumberGenerator autoLottoNumberGenerator = new AutoLottoNumberGenerator();
        int expectedNumberCount = 1;
        Class<LottoTicket> expected = LottoTicket.class;

        // when
        List<LottoTicket> actuals = autoLottoNumberGenerator.generateLottoTickets(expectedNumberCount, null);

        // then
        assertThat(actuals.size()).isEqualTo(expectedNumberCount);
        actuals.forEach(actual -> assertThat(actual).isInstanceOf(expected));
        actuals.forEach(actual ->
                actual.getLottoNumbers().forEach(actualNumber -> {
                    assertThat(actualNumber).isGreaterThanOrEqualTo(LOTTO_NUMBER_LOWERBOUND);
                    assertThat(actualNumber).isLessThanOrEqualTo(LOTTO_NUMBER_UPPERBOUND);
                })
        );
    }
}