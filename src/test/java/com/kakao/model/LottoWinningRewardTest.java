package com.kakao.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LottoWinningRewardTest {

    @Test
    @DisplayName("useBaseBall 은 기본값으로 false 를 가진다.")
    void getUseBaseBall() {
        LottoWinningReward lottoWinningReward = new LottoWinningReward(5);
        assertThat(lottoWinningReward.getUseBaseBall())
                .isEqualTo(false);
    }
}