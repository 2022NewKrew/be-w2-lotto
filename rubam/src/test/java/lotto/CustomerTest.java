package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerTest {

    @Test
    @DisplayName("1등 테스트")
    void calculateRankResultTest1() {
        // given
        int inputMoney = 1000;
        Customer customer = new Customer(new Money(inputMoney));
        List<List<Integer>> ticketList = new ArrayList<>();
        ticketList.add(Arrays.asList(1,2,3,4,5,6));

        List<Integer> winNumbers = Arrays.asList(1,2,3,4,5,6);
        int inputBonusNumber = 7;

        // when
        WinTicket winTicket = new WinTicket(winNumbers, inputBonusNumber);
        TicketsGenerator ticketsGenerator = new DirectTicketsGenerator(ticketList);
        customer.buyAllTickets(ticketsGenerator);

        // then
        Map<Rank, Integer> ranks = customer.calculateRankResult(winTicket);
        assertThat(ranks.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 테스트")
    void calculateRankResultTest2() {
        // given
        int inputMoney = 1000;
        Customer customer = new Customer(new Money(inputMoney));
        List<List<Integer>> ticketList = new ArrayList<>();
        ticketList.add(Arrays.asList(1,2,3,4,5,7));

        List<Integer> winNumbers = Arrays.asList(1,2,3,4,5,6);
        int inputBonusNumber = 7;

        // when
        WinTicket winTicket = new WinTicket(winNumbers, inputBonusNumber);
        TicketsGenerator ticketsGenerator = new DirectTicketsGenerator(ticketList);
        customer.buyAllTickets(ticketsGenerator);

        // then
        Map<Rank, Integer> ranks = customer.calculateRankResult(winTicket);
        assertThat(ranks.get(Rank.SECOND)).isEqualTo(1);
    }
}
