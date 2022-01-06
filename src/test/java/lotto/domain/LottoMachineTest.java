package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("금액에 맞는 개수의 로또 티켓 발급 테스트")
    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300, 10000000})
    void issue(int totalTicketCount) {
        LottoTicketCount ticketCount = new LottoTicketCount(totalTicketCount, 0);
        LottoTickets lottoTickets = LottoMachine.issue(ticketCount, new ArrayList<>());

        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(totalTicketCount);
    }
}