package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketCountTest {

    @DisplayName("자동 로또 개수 테스트")
    @ParameterizedTest
    @CsvSource({"1000, 1", "14000, 10", "2000000, 100"})
    public void autoTicketCountTest(long price, int manualTicketCount) {
        Money inputMoney = new Money(price);
        int totalTicketCount = inputMoney.getNumberOfTickets(LottoMachine.TICKET_PRICE);

        LottoTicketCount lottoTicketCount = new LottoTicketCount(totalTicketCount, manualTicketCount);

        assertThat(lottoTicketCount.getAutoTicketCount()).isEqualTo(totalTicketCount - manualTicketCount);
    }

    @DisplayName("로또 수 음수 입력 테스트")
    @ParameterizedTest
    @CsvSource({"-1, 0", "0, -1", "-1, -1"})
    public void negativeManualTicketCount(int totalTicketCount, int manualTicketCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicketCount(totalTicketCount, manualTicketCount))
                .withMessage("구매할 로또 수는 0개 이상이어야 합니다.");
    }

    @DisplayName("수동 로또 개수가 전체 로또 개수를 초과할 경우 테스트")
    @ParameterizedTest
    @CsvSource({"1000, 2", "14000, 100", "2000000, 2001"})
    public void exceedManualTicketCount(long price, int manualTicketCount) {
        Money inputMoney = new Money(price);
        int totalTicketCount = inputMoney.getNumberOfTickets(LottoMachine.TICKET_PRICE);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicketCount(totalTicketCount, manualTicketCount))
                .withMessage("구매할 수 있는 로또 수를 초과했습니다.");
    }
}