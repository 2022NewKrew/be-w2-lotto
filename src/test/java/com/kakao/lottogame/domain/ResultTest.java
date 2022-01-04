package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    private final List<Rank> RANKS = List.of(Rank.THIRD, Rank.FOURTH, Rank.NONE);
    private final long REWARD = RANKS.stream()
        .map(rank -> rank.getReward().getValue())
        .reduce(0, Integer::sum);

    @DisplayName("Result 생성 시에 모든 Rank에 따른 초기화가 이뤄진다.")
    @Test
    void constructor_EmptyList_Initialized() {
        assertThat(Result.from(Collections.emptyList()).getBoard()).hasSize(Rank.values().length);
    }

    @DisplayName("주어진 Rank에 따라 Result가 초기화된다.")
    @Test
    void constructor_List_Result() {
        Map<Rank, Integer> board = Result.from(RANKS).getBoard();

        assertThat(board.get(Rank.FIRST)).isZero();
        assertThat(board.get(Rank.SECOND)).isZero();
        assertThat(board.get(Rank.THIRD)).isOne();
        assertThat(board.get(Rank.FOURTH)).isOne();
        assertThat(board.get(Rank.NONE)).isOne();
    }

    @DisplayName("투자 금액 대비 수익률을 계산한다.")
    @ParameterizedTest
    @ValueSource(ints = {55_000, 110_000})
    void calculateProfit_Money_Profit(int value) {
        Result result = Result.from(RANKS);
        Money money = Money.of(value);
        assertThat(result.calculateProfit(money)).isEqualTo(REWARD * 100 / value);
    }
}