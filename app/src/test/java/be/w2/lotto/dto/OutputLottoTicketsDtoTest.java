package be.w2.lotto.dto;

import be.w2.lotto.domain.lottoticket.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputLottoTicketsDtoTest {

    int lottoPurchaseAmount;
    List<List<Integer>> lottoNumbers;
    LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lottoPurchaseAmount = 2;
        lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7)
        );
        lottoTickets = LottoTickets.valueOf(lottoPurchaseAmount, lottoNumbers);
    }

    @Test
    void from_객체_생성에_성공하고_OutputLottoTicketsDto_객체를_반환한다() {
        // given
        Class<OutputLottoTicketsDto> expected = OutputLottoTicketsDto.class;

        // when
        OutputLottoTicketsDto actual = OutputLottoTicketsDto.from(lottoTickets);

        // then
        assertThat(actual).isInstanceOf(expected);
    }

    @Test
    void getLottoTicketAmount_객체의_lottoTickets의_크기에_해당하는_값을_반환한다() {
        // given
        OutputLottoTicketsDto outputLottoTicketsDto = OutputLottoTicketsDto.from(lottoTickets);
        int expected = 2;

        // when
        int actual = outputLottoTicketsDto.getLottoTicketsAmount();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
