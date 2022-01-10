package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketCountTest {

    @DisplayName("로또 개수 테스트")
    @ParameterizedTest
    @CsvSource({"1000, 1", "14000, 10", "2000000, 100"})
    public void ticketCountTest(long price, int manualTicketCount) {
        Money inputMoney = new Money(price);
        int totalTicketCount = inputMoney.getNumberOfTickets(LottoMachine.TICKET_PRICE);

        LottoTicketCount lottoTicketCount = new LottoTicketCount(totalTicketCount);

        assertThat(lottoTicketCount.getCount()).isEqualTo(totalTicketCount);
    }

    @DisplayName("로또 수 음수 입력 테스트")
    @ParameterizedTest
    @CsvSource({"-1", "-10", "-100"})
    public void negativeTicketCount(int count) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicketCount(count))
                .withMessage("구매할 로또 수는 0개 이상이어야 합니다.");
    }

    @DisplayName("로또 수 뺄셈 테스트")
    @ParameterizedTest
    @CsvSource({"10, 2", "100, 50", "10000, 2839"})
    public void subTest(int totalCount, int manualCount) {
        LottoTicketCount totalTicketCount = new LottoTicketCount(totalCount);
        LottoTicketCount manualTicketCount = new LottoTicketCount(manualCount);

        LottoTicketCount autoTicketCount = totalTicketCount.sub(manualTicketCount);

        assertThat(autoTicketCount.getCount()).isEqualTo(totalCount - manualCount);
    }

    @DisplayName("로또 수를 뺄셈 하면 음수일 때 테스트")
    @ParameterizedTest
    @CsvSource({"10, 11", "100, 120", "10000, 1000000"})
    public void subNegativeTest(int totalCount, int manualCount) {
        LottoTicketCount totalTicketCount = new LottoTicketCount(totalCount);
        LottoTicketCount manualTicketCount = new LottoTicketCount(manualCount);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> totalTicketCount.sub(manualTicketCount))
                .withMessage("구매할 로또 수는 0개 이상이어야 합니다.");
    }
}