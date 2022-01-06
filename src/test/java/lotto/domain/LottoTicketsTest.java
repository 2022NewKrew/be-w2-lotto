package lotto.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUpEach() {
        lottoTickets = new LottoTickets();
    }

    @DisplayName("랜덤 로또 추가 테스트")
    @Test
    void addRandomLottoTickets() {
        lottoTickets.addRandomLottoTickets(10);
        assertThat(lottoTickets.getTickets().size()).isEqualTo(10);
    }
}