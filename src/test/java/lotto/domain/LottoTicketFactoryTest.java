package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTicketFactoryTest {

    LottoTicketFactory factory = new LottoTicketFactoryImpl();

    @DisplayName("랜덤으로 생성한 로또 티켓의 숫자는 1부터 45 이외의 숫자를 포함하면 안된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createRandomLottoTicket(int number) {
        LottoTicket lottoTicket = factory.createRandomLottoTicket();
        assertThat(lottoTicket.containNumbers(number)).isFalse();
    }

    @DisplayName("전달 받은 숫자 만큼의 로또 티켓이 생성되야 한다.")
    @Test
    void createRandomLottoTickets() {
        int numOfTickets = 6;
        List<LottoTicket> lottoTickets = factory.createRandomLottoTickets(numOfTickets);
        assertThat(lottoTickets.size()).isEqualTo(numOfTickets);
    }
}