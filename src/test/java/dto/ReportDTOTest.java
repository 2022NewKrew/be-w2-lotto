package dto;

import domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportDTOTest {

    @Test
    @DisplayName("수익률은 총상금액/투자액이다.")
    void Given_InvestmentAndPrizeCount_When_MakingReportDTO_Then_CalculateProfitRate() {
        // Given
        final int INVESTMENT = 1_000_000_000;
        final int FIRST_PRIZE_COUNT = 1;
        final int SECOND_PRIZE_COUNT = 2;
        final int THIRD_PRIZE_COUNT = 3;
        final int FOURTH_PRIZE_COUNT = 4;
        final int FIFTH_PRIZE_COUNT = 5;
        Map<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        prizeCount.put(Prize.FIRST, FIRST_PRIZE_COUNT);
        prizeCount.put(Prize.SECOND, SECOND_PRIZE_COUNT);
        prizeCount.put(Prize.THIRD, THIRD_PRIZE_COUNT);
        prizeCount.put(Prize.FOURTH, FOURTH_PRIZE_COUNT);
        prizeCount.put(Prize.FIFTH, FIFTH_PRIZE_COUNT);

        // When
        ReportDTO reportDTO = new ReportDTO(INVESTMENT, prizeCount);

        // Then
        final double PROFIT_RATE = 1.064725;
        assertEquals(PROFIT_RATE, reportDTO.profitRate);
    }
}