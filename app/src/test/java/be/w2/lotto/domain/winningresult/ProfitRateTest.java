package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static be.w2.lotto.common.util.Parser.parseInputNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfitRateTest {
    @Test
    void valueOf_객체_생성에_성공하고_ProfitRate_객체를_반환한다() {
        // given
        LottoTickets lottoTickets = LottoTickets.valueOf(1, List.of(List.of(1, 2, 3, 4, 5, 6)));
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(parseInputNumbers("1, 2, 3, 4, 5, 6"));
        BonusNumber bonusNumber = BonusNumber.valueOf(7, winningLottoTicket);
        WinningResults winningResults = WinningResults.valueOf(lottoTickets, winningLottoTicket, 1, bonusNumber);
        int purchaseAmount = 1;
        Class<ProfitRate> expected = ProfitRate.class;

        // when
        ProfitRate actual = ProfitRate.valueOf(winningResults.getWinningMatchResults(), purchaseAmount);

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
        int purchaseAmount = 1;
        ProfitRate profitRate = ProfitRate.valueOf(winningResults.getWinningMatchResults(), purchaseAmount);
        BigInteger expected = BigInteger.valueOf(200000000000L);

        // when
        BigInteger actual = profitRate.getProfitRate();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}