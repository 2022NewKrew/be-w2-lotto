package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTicketsTest {

    @Test
    @DisplayName("로또 티켓 뭉치의 등급별 계수는 올바르게 집계되어야 합니다.")
    void Given_LotteryTicketsAndLotteryResult_When_CountPrize_Then_CountCorrectly() {
        // Given
        LotteryResult lotteryResult = new LotteryResult(List.of(1,2,3,4,5,6), 7);
        LotteryTicket firstPrizeTicket = new LotteryTicket(List.of(1,2,3,4,5,6));
        LotteryTicket secondPrizeTicket = new LotteryTicket(List.of(1,2,3,4,5,7));
        LotteryTicket thirdPrizeTicket = new LotteryTicket(List.of(1,2,3,4,5,8));
        LotteryTicket fourthPrizeTicket = new LotteryTicket(List.of(1,2,3,4,8,9));
        LotteryTicket fifthPrizeTicket = new LotteryTicket(List.of(1,2,3,8,9,10));
        LotteryTicket nonePrizeTicket1 = new LotteryTicket(List.of(1,2,8,9,10,11));
        LotteryTicket nonePrizeTicket2 = new LotteryTicket(List.of(1,8,9,10,11,12));
        LotteryTicket nonePrizeTicket3 = new LotteryTicket(List.of(8,9,10,11,12,13));
        LotteryTickets lotteryTickets = new LotteryTickets(List.of(
                firstPrizeTicket,
                secondPrizeTicket,
                thirdPrizeTicket,
                fourthPrizeTicket,
                fifthPrizeTicket,
                nonePrizeTicket1,
                nonePrizeTicket2,
                nonePrizeTicket3));

        // When
        Map<LotteryPrize, Integer> actualPrizeCount = lotteryTickets.getPrizeCount(lotteryResult);

        // Then
        Map<LotteryPrize, Integer> expectedPrizeCount = new HashMap<>();
        expectedPrizeCount.put(LotteryPrize.FIRST, 1);
        expectedPrizeCount.put(LotteryPrize.SECOND, 1);
        expectedPrizeCount.put(LotteryPrize.THIRD, 1);
        expectedPrizeCount.put(LotteryPrize.FOURTH, 1);
        expectedPrizeCount.put(LotteryPrize.FIFTH, 1);
        expectedPrizeCount.put(LotteryPrize.NONE, 3);
        assertEquals(expectedPrizeCount, actualPrizeCount);
    }
}