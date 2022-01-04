package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("숫자를 맞춘 개수에 따라 보상이 달라진다.")
    @Test
    void of_Match_Reward() {
        assertThat(Rank.of(0)).isEqualTo(Rank.NONE);
        assertThat(Rank.of(1)).isEqualTo(Rank.NONE);
        assertThat(Rank.of(2)).isEqualTo(Rank.NONE);
        assertThat(Rank.of(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(6)).isEqualTo(Rank.FIRST);
    }
}