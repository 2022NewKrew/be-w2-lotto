package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static be.w2.lotto.common.util.Parser.parseInputNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningResultsTest {

    @Test
    void valueOf_객체_생성에_성공하고_WinningResults_객체를_반환한다() {
        // given
        LottoTickets lottoTickets = LottoTickets.valueOf(1, List.of());
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(parseInputNumbers("1, 2, 3, 4, 5, 6"));
        BonusNumber bonusNumber = BonusNumber.valueOf(7, winningLottoTicket);
        Class<WinningResults> expected = WinningResults.class;

        // when
        WinningResults actual = WinningResults.valueOf(lottoTickets, winningLottoTicket, 1, bonusNumber);

        // then
        assertThat(actual).isInstanceOf(expected);
    }

    @Test
    void getProfitRate_객체의_profitRate에_해당하는_BigInteger를_반환한다() {
        // given
        LottoTickets lottoTickets = LottoTickets.valueOf(1, List.of(List.of(1, 2, 3, 4, 5, 6)));
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(parseInputNumbers("1, 2, 3, 4, 5, 6"));
        BonusNumber bonusNumber = BonusNumber.valueOf(7, winningLottoTicket);
        WinningResults winningResults = WinningResults.valueOf(lottoTickets, winningLottoTicket, 1, bonusNumber);
        BigInteger expected = BigInteger.valueOf(200000000000L);

        // when
        BigInteger actual = winningResults.getProfitRate();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getWinningMatchResults_객체의_winningMatchResult에_해당하는_객체_리스트를_반환한다() {
        // given
        LottoTickets lottoTickets = LottoTickets.valueOf(1, List.of(List.of(1, 2, 3, 4, 5, 6)));
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(parseInputNumbers("1, 2, 3, 4, 5, 6"));
        BonusNumber bonusNumber = BonusNumber.valueOf(7, winningLottoTicket);
        WinningResults winningResults = WinningResults.valueOf(lottoTickets, winningLottoTicket, 1, bonusNumber);
        Class<WinningResult> expected = WinningResult.class;

        // when
        List<WinningResult> actuals = winningResults.getWinningMatchResults();

        // then
        actuals.forEach(actual -> assertThat(actual).isInstanceOf(expected));
    }
}