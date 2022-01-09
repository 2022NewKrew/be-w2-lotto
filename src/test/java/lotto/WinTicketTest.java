package lotto;

import lotto.domain.Rank;
import lotto.domain.Ticket;
import lotto.domain.WinTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinTicketTest {

    @Test
    @DisplayName("중복된 보너스 번호 테스트")
    void duplicatedBonusNumberTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        // then
        String errorMessage = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new WinTicket(numbers, bonusNumber);
        }).getMessage();
        assertThat(errorMessage).isEqualTo("중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("당첨 결과 조회 테스트")
    void ticketRankCheckTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        Ticket ticket = new Ticket(numbers);
        WinTicket winTicket = new WinTicket(numbers, bonusNumber);

        // then
        assertThat(winTicket.checkTicketRank(ticket)).isEqualTo(Rank.FIRST);
    }
}
