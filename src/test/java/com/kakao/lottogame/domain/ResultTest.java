package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    private final List<Rank> RANKS = List.of(Rank.THIRD, Rank.FOURTH, Rank.NONE);
    private final long REWARD = RANKS.stream()
        .map(Rank::getRewardValue)
        .reduce(0, Integer::sum);

    @DisplayName("Result 생성 시에 모든 Rank에 따른 초기화가 이뤄진다.")
    @Test
    void constructor_EmptyList_Initialized() {
        Result result = Result.from(Collections.emptyList());

        assertThat(result.getCountOf(Rank.FIRST)).isZero();
        assertThat(result.getCountOf(Rank.SECOND)).isZero();
        assertThat(result.getCountOf(Rank.THIRD)).isZero();
        assertThat(result.getCountOf(Rank.FOURTH)).isZero();
        assertThat(result.getCountOf(Rank.NONE)).isZero();
    }

    @DisplayName("주어진 Rank에 따라 Result가 초기화된다.")
    @Test
    void constructor_List_Result() {
        Result result = Result.from(RANKS);

        assertThat(result.getCountOf(Rank.FIRST)).isZero();
        assertThat(result.getCountOf(Rank.SECOND)).isZero();
        assertThat(result.getCountOf(Rank.THIRD)).isOne();
        assertThat(result.getCountOf(Rank.FOURTH)).isOne();
        assertThat(result.getCountOf(Rank.NONE)).isOne();
    }

    @DisplayName("투자 금액 대비 수익률을 계산한다.")
    @ParameterizedTest
    @ValueSource(ints = {55_000, 110_000})
    void calculateProfit_Money_Profit(int value) {
        Result result = Result.from(RANKS);
        Money money = Money.of(value);
        assertThat(result.calculateProfitRate(money)).isEqualTo(REWARD * 100 / value);
    }
}