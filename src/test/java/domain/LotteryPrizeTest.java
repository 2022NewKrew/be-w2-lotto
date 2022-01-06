package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryPrizeTest {
    @Test
    @DisplayName("로또 번호 6개 매치는 1등입니다.")
    void Given_SixMatchingLotteryResultAndLotteryTicket_When_EvaluatePrize_Then_GetFirstPrize() {
        // Given
        LotteryResult lotteryResult = new LotteryResult(List.of(1,2,3,4,5,6), 7);
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1,2,3,4,5,6));

        // When
        LotteryPrize lotteryPrize = LotteryPrize.getPrize(lotteryResult, lotteryTicket);

        // Then
        assertEquals(LotteryPrize.FIRST, lotteryPrize);
    }

    @Test
    @DisplayName("로또 번호 5개 매치, 보너스 볼 매치는 2등입니다.")
    void Given_FiveMatchingAndBonusBallMatchingLotteryResultAndLotteryTicket_When_EvaluatePrize_Then_GetSecondPrize() {
        // Given
        LotteryResult lotteryResult = new LotteryResult(List.of(1,2,3,4,5,6), 7);
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1,2,3,4,5,7));

        // When
        LotteryPrize lotteryPrize = LotteryPrize.getPrize(lotteryResult, lotteryTicket);

        // Then
        assertEquals(LotteryPrize.SECOND, lotteryPrize);
    }

    @Test
    @DisplayName("로또 번호 5개 매치는 3등입니다.")
    void Given_FiveMatchingLotteryResultAndLotteryTicket_When_EvaluatePrize_Then_GetThirdPrize() {
        // Given
        LotteryResult lotteryResult = new LotteryResult(List.of(1,2,3,4,5,6), 7);
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1,2,3,4,5,8));

        // When
        LotteryPrize lotteryPrize = LotteryPrize.getPrize(lotteryResult, lotteryTicket);

        // Then
        assertEquals(LotteryPrize.THIRD, lotteryPrize);
    }

    @Test
    @DisplayName("로또 번호 4개 매치는 4등입니다.")
    void Given_FourMatchingLotteryResultAndLotteryTicket_When_EvaluatePrize_Then_GetFourthPrize() {
        // Given
        LotteryResult lotteryResult = new LotteryResult(List.of(1,2,3,4,5,6), 7);
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1,2,3,4,8,9));

        // When
        LotteryPrize lotteryPrize = LotteryPrize.getPrize(lotteryResult, lotteryTicket);

        // Then
        assertEquals(LotteryPrize.FOURTH, lotteryPrize);
    }

    @Test
    @DisplayName("로또 번호 3개 매치는 5등입니다.")
    void Given_ThreeMatchingLotteryResultAndLotteryTicket_When_EvaluatePrize_Then_GetFifthPrize() {
        // Given
        LotteryResult lotteryResult = new LotteryResult(List.of(1,2,3,4,5,6), 7);
        LotteryTicket lotteryTicket = new LotteryTicket(List.of(1,2,3,8,9,10));

        // When
        LotteryPrize lotteryPrize = LotteryPrize.getPrize(lotteryResult, lotteryTicket);

        // Then
        assertEquals(LotteryPrize.FIFTH, lotteryPrize);
    }


    @Test
    @DisplayName("로또 번호 0~2개 매치는 상금이 없습니다.")
    void Given_ZeroToTwoMatchingLotteryResultAndLotteryTicket_When_EvaluatePrize_Then_GetNonePrize() {
        // Given
        LotteryResult lotteryResult = new LotteryResult(List.of(1,2,3,4,5,6), 7);
        LotteryTicket twoMatchingLotteryTicket = new LotteryTicket(List.of(1,2,8,9,10,11));
        LotteryTicket oneMatchingLotteryTicket = new LotteryTicket(List.of(1,8,9,10,11,12));
        LotteryTicket zeroMatchingLotteryTicket = new LotteryTicket(List.of(8,9,10,11,12,13));

        // When
        LotteryPrize twoMatchingLotteryPrize = LotteryPrize.getPrize(lotteryResult, twoMatchingLotteryTicket);
        LotteryPrize oneMatchingLotteryPrize = LotteryPrize.getPrize(lotteryResult, oneMatchingLotteryTicket);
        LotteryPrize zeroMatchingLotteryPrize = LotteryPrize.getPrize(lotteryResult, zeroMatchingLotteryTicket);

        // Then
        assertEquals(LotteryPrize.NONE, twoMatchingLotteryPrize);
        assertEquals(LotteryPrize.NONE, oneMatchingLotteryPrize);
        assertEquals(LotteryPrize.NONE, zeroMatchingLotteryPrize);
    }
}