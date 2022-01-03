package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardTest {

    @DisplayName("숫자를 맞춘 개수에 따라 보상이 달라진다.")
    @Test
    void of_Match_Reward() {
        assertThat(Reward.of(0)).isEqualTo(Reward.NONE);
        assertThat(Reward.of(1)).isEqualTo(Reward.NONE);
        assertThat(Reward.of(2)).isEqualTo(Reward.NONE);
        assertThat(Reward.of(3)).isEqualTo(Reward.FOURTH);
        assertThat(Reward.of(4)).isEqualTo(Reward.THIRD);
        assertThat(Reward.of(5)).isEqualTo(Reward.SECOND);
        assertThat(Reward.of(6)).isEqualTo(Reward.FIRST);
    }
}