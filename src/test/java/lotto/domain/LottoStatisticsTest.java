package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @DisplayName("로또 번호가 6개 일치할 때 매치 테스트")
    @Test
    public void match() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }

        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);

        WinningNumbers winningNumbers = WinningNumbers.from(lottoNumbers);

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(lottoNumbers));

        LottoTickets lottoTickets = LottoTickets.from(tickets);

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, lottoTickets);

        assertThat(lottoStatistics.getResultMap().get(LottoResult.FIRST)).isEqualTo(1);
    }
}