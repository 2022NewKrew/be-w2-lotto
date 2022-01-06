package domain;

import dto.LotteryReportDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LotteryReportTest {
    @Test
    @DisplayName("수익률은 수익/비용이어야 합니다.")
    void Given_PrizeCountAndCost_When_MakingReportDTO_Then_CalculateProfitRate() {
        // Given
        final int COST = 1_000_000_000;
        final int FIRST_PRIZE_COUNT = 1;
        final int SECOND_PRIZE_COUNT = 2;
        final int THIRD_PRIZE_COUNT = 3;
        final int FOURTH_PRIZE_COUNT = 4;
        final int FIFTH_PRIZE_COUNT = 5;
        Map<LotteryPrize, Integer> prizeCount = new EnumMap<>(LotteryPrize.class);
        prizeCount.put(LotteryPrize.FIRST, FIRST_PRIZE_COUNT);
        prizeCount.put(LotteryPrize.SECOND, SECOND_PRIZE_COUNT);
        prizeCount.put(LotteryPrize.THIRD, THIRD_PRIZE_COUNT);
        prizeCount.put(LotteryPrize.FOURTH, FOURTH_PRIZE_COUNT);
        prizeCount.put(LotteryPrize.FIFTH, FIFTH_PRIZE_COUNT);

        // When
        LotteryReport lotteryReport = new LotteryReport(prizeCount, COST);

        // Then
        final double PROFIT_RATE = 1.064725;
        assertEquals(PROFIT_RATE, lotteryReport.toDTO().profitRate);
    }

}