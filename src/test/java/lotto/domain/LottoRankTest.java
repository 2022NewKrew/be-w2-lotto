package lotto.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoRankTest {

    @DisplayName("2등 반환 확인")
    @Test
    void valueOfSecond() {
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("3등 반환 확인")
    @Test
    void valueOfThird() {
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("꽝 확인")
    @Test
    void valueOfNull() {
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(null);
    }
}