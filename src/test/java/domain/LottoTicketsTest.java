package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    @DisplayName("[성공] LottoTickets 객체를 생성한다")
    void LottoTickets() {
        List<LottoTicket> manualTicket = List.of(lottoTicket(1, 2, 3, 4, 5, 6), lottoTicket(1, 2, 3, 4, 5, 7));
        List<LottoTicket> randomTicket = List.of(lottoTicket(1, 2, 3, 4, 5, 6), lottoTicket(1, 2, 3, 4, 5, 7));

        new LottoTickets(manualTicket, randomTicket);
    }

    @Test
    @DisplayName("[성공] LottoTickets 객체를 생성한다 - 티켓 리스트가 비어있는 경우")
    void LottoTickets_EmptyList() {
        List<LottoTicket> manualTicket = new ArrayList<>();
        List<LottoTicket> randomTicket = new ArrayList<>();

        new LottoTickets(manualTicket, randomTicket);
    }

    @Test
    @DisplayName("[실패] 생성자에 null을 넣을 시 IllegalArgumentException을 던져야 한다")
    void LottoTickets_Failed_By_Null() {
        List<LottoTicket> manualTicket = null;
        List<LottoTicket> randomTicket = null;

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new LottoTickets(manualTicket, randomTicket));
    }

    @Test
    @DisplayName("[성공] 수동 티켓과 자동 티켓을 들고온다")
    void totalTickets() {
        List<LottoTicket> manualTicket = List.of(lottoTicket(1, 2, 3, 4, 5, 6), lottoTicket(1, 2, 3, 4, 5, 7));
        List<LottoTicket> randomTicket = List.of(lottoTicket(1, 2, 3, 4, 5, 8), lottoTicket(1, 2, 3, 4, 5, 9));
        List<LottoTicket> totalTicket = List.of(lottoTicket(1, 2, 3, 4, 5, 6), lottoTicket(1, 2, 3, 4, 5, 7),
                lottoTicket(1, 2, 3, 4, 5, 8), lottoTicket(1, 2, 3, 4, 5, 9));

        LottoTickets lottoTickets = new LottoTickets(manualTicket, randomTicket);

        Assertions.assertEquals(lottoTickets.totalTickets(), totalTicket);
    }

    LottoTicket lottoTicket(int n1, int n2, int n3, int n4, int n5, int n6) {
        Set<LottoNumber> numbers = Set.of(LottoNumber.from(n1), LottoNumber.from(n2), LottoNumber.from(n3),
                LottoNumber.from(n4), LottoNumber.from(n5), LottoNumber.from(n6));

        return new LottoTicket(numbers);
    }
}