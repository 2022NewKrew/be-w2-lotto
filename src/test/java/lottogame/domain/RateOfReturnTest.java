package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateOfReturnTest {

    @Test
    @DisplayName("순위 매기기")
    void checkCalculateRateOfReturn() {
        assertThat(RateOfReturn.calculate(3000, 1000).getRateOfReturn()).isEqualTo(200);
    }
}