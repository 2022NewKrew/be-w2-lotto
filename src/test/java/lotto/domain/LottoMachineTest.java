package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("금액에 맞는 개수의 로또 티켓 발급 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 1500, 2000, 2999})
    void issue(int inputPrice) {
        LottoTickets lottoTickets = LottoMachine.issue(new Money(inputPrice), new RandomLottoNumberGenerator());

        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(inputPrice / LottoMachine.TICKET_PRICE);
    }
}