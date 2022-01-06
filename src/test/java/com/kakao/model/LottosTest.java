package com.kakao.model;

import static org.assertj.core.api.Assertions.*;

import com.kakao.exception.MoneyRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("인자 lottoWinning 이 null이면, 빈 맵을 반환한다")
    void lottoWinningIsNotNull() throws MoneyRangeException {
        Money money = new Money(1000);
        Lottos lottos = new Lottos(money);

        assertThat(lottos.matchLottosAreWinning(null))
                .isNotEqualTo(null);
    }
}