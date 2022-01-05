package lotto.domain;


import lotto.VO.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankCountsTest {
    private RankCounts rewards;

    @BeforeEach
    void setUp() {
        rewards = new RankCounts();
    }

    @Test
    @DisplayName("총 상금을 계산합니다.")
    void getTotalRewardTest() {
        int expectedTotalReward = 0;
        rewards.addReward(5, false);
        expectedTotalReward += Rank.valueOf(5, false).getWinningMoney();
        rewards.addReward(6, false);
        expectedTotalReward += Rank.valueOf(6, false).getWinningMoney();
        rewards.addReward(5, true);
        expectedTotalReward += Rank.valueOf(5, true).getWinningMoney();
        rewards.addReward(4, false);
        expectedTotalReward += Rank.valueOf(4, false).getWinningMoney();

        assertThat(rewards.getTotalReward()).isEqualTo(expectedTotalReward);
    }
}