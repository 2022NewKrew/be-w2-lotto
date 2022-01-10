package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LotteryTicketsTest {

    @Test
    @DisplayName("로또티켓 리스트 생성하기")
    void throwExceptionWhenCreateLotteryTickets() {
        List<List<Integer>> integers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12)
        );

        new LotteryTickets(integers, 2);
    }

    @Test
    @DisplayName("로또티켓 순위 매기기")
    void rankLotteryTickets() {
        WinningTicket winningTicket = new WinningTicket(
                new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LotteryNumber(7)
        );

        List<List<Integer>> integers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(2, 3, 4, 5, 6, 7),
                Arrays.asList(2, 3, 4, 5, 6, 8),
                Arrays.asList(3, 4, 5, 6, 7, 8),
                Arrays.asList(4, 5, 6, 7, 8, 9),
                Arrays.asList(5, 6, 7, 8, 9, 10)
        );
        LotteryTickets lotteryTickets = new LotteryTickets(integers, 6);

        assertThat(lotteryTickets.rankTickets(winningTicket).getRanks()).isEqualTo(
                Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.NO_RANK)
        );
    }

    @Test
    @DisplayName("티켓 합치기 확인")
    void checkCombineTickets() {
        List<List<Integer>> integersA = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(2, 3, 4, 5, 6, 7)
        );
        List<List<Integer>> integersB = Arrays.asList(
                Arrays.asList(2, 3, 4, 5, 6, 8),
                Arrays.asList(3, 4, 5, 6, 7, 8)
        );
        LotteryTickets ticketsA = new LotteryTickets(integersA, 2);
        LotteryTickets ticketsB = new LotteryTickets(integersB, 2);

        List<List<Integer>> integers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(2, 3, 4, 5, 6, 7),
                Arrays.asList(2, 3, 4, 5, 6, 8),
                Arrays.asList(3, 4, 5, 6, 7, 8)
        );
        LotteryTickets totalTickets = new LotteryTickets(integers, 4);

        assertThat(ticketsA.combine(ticketsB)).isEqualTo(totalTickets);

    }
}