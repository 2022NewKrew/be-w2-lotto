package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @DisplayName("로또 번호가 6개 일치할 때 매치 테스트")
    @Test
    public void match() {
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }

        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);
        LottoNumber bonusNumber = LottoNumber.from(7);

        WinningNumbers winningNumbers = WinningNumbers.from(lottoNumbers, bonusNumber);

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(lottoNumbers));

        LottoTickets lottoTickets = LottoTickets.from(tickets);

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, lottoTickets);

        assertThat(lottoStatistics.getResultMap().get(LottoResult.FIRST)).isEqualTo(1);
    }

    @DisplayName("1개 로또를 구매해서 1등 당첨일 때 수익률 계산 테스트")
    @Test
    public void calculateRevenueRate() {
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }

        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);
        LottoNumber bonusNumber = LottoNumber.from(7);

        WinningNumbers winningNumbers = WinningNumbers.from(lottoNumbers, bonusNumber);

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(lottoNumbers));

        LottoTickets lottoTickets = LottoTickets.from(tickets);

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, lottoTickets);

        assertThat(lottoStatistics.calculateRevenueRate(new Money(1000))).isEqualTo(200000000);
    }

    @DisplayName("2등 당첨 테스트")
    @Test
    public void secondWinning() {
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }

        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);
        LottoNumber bonusNumber = LottoNumber.from(7);

        WinningNumbers winningNumbers = WinningNumbers.from(lottoNumbers, bonusNumber);

        Set<LottoNumber> ticketNumbers = new HashSet<>();
        for (int i = 2; i <= 7; i++) {
            ticketNumbers.add(LottoNumber.from(i));
        }
        LottoNumbers ticketLottoNumbers = LottoNumbers.from(ticketNumbers);
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(ticketLottoNumbers));

        LottoTickets lottoTickets = LottoTickets.from(tickets);

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, lottoTickets);

        assertThat(lottoStatistics.calculateRevenueRate(new Money(1000))).isEqualTo(3000000);
    }
}