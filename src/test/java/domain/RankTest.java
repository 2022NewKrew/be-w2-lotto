package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("보너스 번호를 맞춘 경우 테스트")
    @Test
    void isCorrectRankWithMatchBonusTrue() {
        // given
        int countOfMatch = 5;
        boolean matchBonus = true;

        // when
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("보너스 번호를 못 맞춘 경우 테스트")
    @Test
    void isCorrectRankWithMatchBonusFalse() {
        // given
        int countOfMatch = 5;
        boolean matchBonus = false;

        // when
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

}