package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    @Test
    @DisplayName("수익률은 총상금액/투자액이다.")
    void getProfitRateAsPercentage() {
        final int INVESTMENT = 100000;
        final int FIRST_PRIZE_COUNT = 1;
        final int SECOND_PRIZE_COUNT = 2;
        final int THIRD_PRIZE_COUNT = 3;
        final int FOURTH_PRIZE_COUNT = 4;
        final int PROFIT_RATE_AS_PERCENTAGE = -50;

        EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        prizeCount.put(Prize.FIRST, FIRST_PRIZE_COUNT);
        prizeCount.put(Prize.SECOND, SECOND_PRIZE_COUNT);
        prizeCount.put(Prize.THIRD, THIRD_PRIZE_COUNT);
        prizeCount.put(Prize.FOURTH, FOURTH_PRIZE_COUNT);
        Report report = new Report(INVESTMENT, prizeCount);
        assertEquals(report.getProfitRateAsPercentage(), PROFIT_RATE_AS_PERCENTAGE);
    }
}