package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.kakao.lottogame.domain.Rank.Criteria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("맞춘 번호(보너스 포함)에 따라 Rank가 달라진다.")
    @Test
    void of_Criteria_Rank() {
        assertThat(Rank.of(Criteria.of(0, false))).isEqualTo(Rank.NONE);
        assertThat(Rank.of(Criteria.of(3, false))).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(Criteria.of(4, false))).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(Criteria.of(5, false))).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(Criteria.of(5, true))).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(Criteria.of(6, false))).isEqualTo(Rank.FIRST);
    }
}