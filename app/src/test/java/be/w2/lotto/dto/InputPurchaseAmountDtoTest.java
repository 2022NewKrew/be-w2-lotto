package be.w2.lotto.dto;

import be.w2.lotto.domain.lottoticket.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputPurchaseAmountDtoTest {

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
    void of_객체_생성에_성공하고_OutputLottoTicketsDto_객체를_반환한다() {
        // given
        Class<InputPurchaseAmountDto> expected = InputPurchaseAmountDto.class;

        // when
        InputPurchaseAmountDto actual = InputPurchaseAmountDto.of(lottoTickets, 1, 1);

        // then
        assertThat(actual).isInstanceOf(expected);
    }
}
