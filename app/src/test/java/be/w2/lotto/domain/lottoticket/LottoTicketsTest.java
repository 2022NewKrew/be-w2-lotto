package be.w2.lotto.domain.lottoticket;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTicketsTest {

    @Test
    void valueOf_객체_생성에_성공하고_LottoTickets_객체를_반환한다() {
        // given
        int lottoPurchaseAmount = 2;
        List<List<Integer>> expectedLottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7)
        );
        Class<LottoTickets> expected = LottoTickets.class;

        // when
        LottoTickets actual = LottoTickets.valueOf(lottoPurchaseAmount, expectedLottoNumbers);

        // then
        assertThat(actual).isInstanceOf(expected);
        List<List<Integer>> actualLottoNumbers = actual.getLottoTickets().stream()
                .map(LottoTicket::getLottoNumbers)
                .collect(Collectors.toList());
        assertThat(actualLottoNumbers).isEqualTo(expectedLottoNumbers);
    }

    @Test
    void getLottoTickets_객체의_lottoTicket에_해당하는_객체_리스트를_반환한다() {
        // given
        int lottoPurchaseAmount = 2;
        List<List<Integer>> expectedLottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7)
        );
        Class<LottoTicket> expected = LottoTicket.class;
        LottoTickets lottoTickets = LottoTickets.valueOf(lottoPurchaseAmount, expectedLottoNumbers);

        // when
        List<LottoTicket> actuals = lottoTickets.getLottoTickets();

        // then
        actuals.forEach(actual -> assertThat(actual).isInstanceOf(expected));
    }
}