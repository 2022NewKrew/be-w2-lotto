package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("로또 티켓 10개 생성 테스트")
    @Test
    public void create() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }
        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tickets.add(new LottoTicket(lottoNumbers));
        }

        LottoTickets lottoTickets = LottoTickets.from(tickets);

        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(10);
    }
}