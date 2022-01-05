package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTypeTest {

    @Test
    @DisplayName("로또 번호 6개를 맞춘경우 1등이어야 한다.")
    void firstPrizeTest() {
        // given
        int matchCount = 6;
        boolean matchBonus = false;

        // when
        PrizeType prizeType = PrizeType.valueOf(matchCount, matchBonus);

        // then
        assertThat(prizeType).isEqualTo(PrizeType.FIRST_PRIZE);
    }

    @Test
    @DisplayName("로또 번호 5개와 보너스 번호를 맞춘경우 2등이어야 한다.")
    void secondPrizeTest() {
        // given
        int matchCount = 5;
        boolean matchBonus = true;

        // when
        PrizeType prizeType = PrizeType.valueOf(matchCount, matchBonus);

        // then
        assertThat(prizeType).isEqualTo(PrizeType.SECOND_PRIZE);
    }

    @Test
    @DisplayName("로또 번호 5개를 맞춘경우 3등이어야 한다.")
    void thirdPrizeTest() {
        // given
        int matchCount = 5;
        boolean matchBonus = false;

        // when
        PrizeType prizeType = PrizeType.valueOf(matchCount, matchBonus);

        // then
        assertThat(prizeType).isEqualTo(PrizeType.THIRD_PRIZE);
    }

    @Test
    @DisplayName("로또 번호 4개를 맞춘경우 4등이어야 한다.")
    void fourthPrizeTest() {
        // given
        int matchCount = 4;
        boolean matchBonus = false;

        // when
        PrizeType prizeType = PrizeType.valueOf(matchCount, matchBonus);

        // then
        assertThat(prizeType).isEqualTo(PrizeType.FOURTH_PRIZE);
    }

    @Test
    @DisplayName("로또 번호 3개를 맞춘경우 5등이어야 한다.")
    void fifthPrizeTest() {
        // given
        int matchCount = 3;
        boolean matchBonus = false;

        // when
        PrizeType prizeType = PrizeType.valueOf(matchCount, matchBonus);

        // then
        assertThat(prizeType).isEqualTo(PrizeType.FIFTH_PRIZE);
    }

    @DisplayName("로또 번호 2개 이하로 맞춘경우 꽝이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2})
    void nonPrizeTest(int matchCount) {
        // given
        boolean matchBonus = false;

        // when
        PrizeType prizeType = PrizeType.valueOf(matchCount, matchBonus);

        // then
        assertThat(prizeType).isEqualTo(null);
    }
}
