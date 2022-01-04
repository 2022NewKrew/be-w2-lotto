package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    /*
        FOURTH -> 50,000원
        FIFTH  ->  5,000원
        total     55,000원
        수익률 = (평가 금액 - 원금) / 원금 * 100
     */
    private final List<Rank> RANKS = List.of(Rank.FOURTH, Rank.FIFTH, Rank.NONE);

    @DisplayName("Result 생성 시에 모든 Rank에 따른 초기화가 이뤄진다.")
    @Test
    void constructor_EmptyList_Initialized() {
        Result result = Result.from(Collections.emptyList());

        assertThat(result.getCountOf(Rank.FIRST)).isZero();
        assertThat(result.getCountOf(Rank.SECOND)).isZero();
        assertThat(result.getCountOf(Rank.THIRD)).isZero();
        assertThat(result.getCountOf(Rank.FOURTH)).isZero();
        assertThat(result.getCountOf(Rank.FIFTH)).isZero();
        assertThat(result.getCountOf(Rank.NONE)).isZero();
    }

    @DisplayName("주어진 Rank에 따라 Result가 초기화된다.")
    @Test
    void constructor_List_Result() {
        Result result = Result.from(RANKS);

        assertThat(result.getCountOf(Rank.FIRST)).isZero();
        assertThat(result.getCountOf(Rank.SECOND)).isZero();
        assertThat(result.getCountOf(Rank.THIRD)).isZero();
        assertThat(result.getCountOf(Rank.FOURTH)).isOne();
        assertThat(result.getCountOf(Rank.FIFTH)).isOne();
        assertThat(result.getCountOf(Rank.NONE)).isOne();
    }

    @DisplayName("투자 금액 대비 수익률을 계산한다. 원금 11,000원 -> 400%")
    @Test
    void calculateProfitRate_11000Won_400Percent() {
        Result result = Result.from(RANKS);
        Money money = Money.of(11_000);
        assertThat(result.calculateProfitRate(money)).isEqualTo(400L);
    }

    @DisplayName("투자 금액 대비 수익률을 계산한다. 원금 110,000원 -> -50%")
    @Test
    void calculateProfitRate_110000Won_Minus50Percent() {
        Result result = Result.from(RANKS);
        Money money = Money.of(110_000);
        assertThat(result.calculateProfitRate(money)).isEqualTo(-50L);
    }
}