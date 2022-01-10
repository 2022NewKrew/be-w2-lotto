package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("순위 매기기")
    void checkMatchRank() {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);

        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);

        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);

        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);

        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);

        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.NO_RANK);
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.NO_RANK);

        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.NO_RANK);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.NO_RANK);
    }

    @Test
    @DisplayName("상금 계산하기")
    void checkCalculatePrizeMoney() {
        int count = 10;
        assertThat(Rank.FIRST.calculatePrizeMoney(count)).isEqualTo(Rank.FIRST.getPrizeMoney() * count);
    }
}