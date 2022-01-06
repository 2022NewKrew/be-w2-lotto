package be.w2.lotto.dto;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;
import be.w2.lotto.domain.winningresult.Rewards;
import be.w2.lotto.domain.winningresult.WinningResult;
import be.w2.lotto.domain.winningresult.WinningResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputWinningResultsDtoTest {

    int lottoPurchaseAmount;
    List<List<Integer>> lottoNumbers;
    LottoTickets lottoTickets;
    List<Integer> winningLottoNumbers;
    WinningLottoTicket winningLottoTicket;
    BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lottoPurchaseAmount = 2;
        lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7)
        );
        lottoTickets = LottoTickets.valueOf(lottoPurchaseAmount, lottoNumbers);
        winningLottoNumbers = List.of(2, 3, 4, 5, 6, 7);
        winningLottoTicket = WinningLottoTicket.valueOf(winningLottoNumbers);
        bonusNumber = BonusNumber.valueOf(8, winningLottoTicket);
    }

    @Test
    void from_객체_생성에_성공하고_OutputWinningResultsDto_객체를_반환한다() {
        // given
        Class<OutputWinningResultsDto> expected = OutputWinningResultsDto.class;
        WinningResults winningResults = WinningResults.valueOf(lottoTickets, winningLottoTicket, 1, bonusNumber);

        // when
        OutputWinningResultsDto actual = OutputWinningResultsDto.from(winningResults);

        // then
        assertThat(actual).isInstanceOf(expected);
    }
}