package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {

    @DisplayName("금액에 맞는 개수의 로또 티켓 발급 테스트")
    @ParameterizedTest
    @CsvSource({"10", "100", "10000"})
    void issue(int autoCount) {
        LottoTicketCount autoTicketCount = new LottoTicketCount(autoCount);
        LottoTicketCount manualTicketCount = new LottoTicketCount(0);

        LottoTickets lottoTickets = LottoMachine.issue(autoTicketCount, manualTicketCount, new ArrayList<>());

        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(autoCount);
    }
}