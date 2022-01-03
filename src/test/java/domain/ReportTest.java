package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    @Test
    @DisplayName("수익률은 총상금액/투자액이다.")
    void getProfitRateAsPercentage() {
        final int INVESTMENT = 100000;
        final int FIRST_PRIZE_VALUE = 20000;
        final int SECOND_PRIZE_VALUE = 10000;
        final int THIRD_PRIZE_VALUE = 2000;
        final int FOURTH_PRIZE_VALUE = 1000;
        final int FIRST_PRIZE_COUNT = 1;
        final int SECOND_PRIZE_COUNT = 2;
        final int THIRD_PRIZE_COUNT = 3;
        final int FOURTH_PRIZE_COUNT = 4;
        final int PROFIT_RATE_AS_PERCENTAGE = 50;

        Report report = new Report(INVESTMENT, FIRST_PRIZE_VALUE, SECOND_PRIZE_VALUE, THIRD_PRIZE_VALUE, FOURTH_PRIZE_VALUE, FIRST_PRIZE_COUNT, SECOND_PRIZE_COUNT, THIRD_PRIZE_COUNT, FOURTH_PRIZE_COUNT);
        assertEquals(report.getProfitRateAsPercentage(), PROFIT_RATE_AS_PERCENTAGE);
    }
}