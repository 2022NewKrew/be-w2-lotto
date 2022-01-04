package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoHandlerTest {

    @Test
    @DisplayName("5등 1개, 4등 1개일 때 결과값은 55,000원이어야 한다.")
    void getTotalWinningAmount_1() {
        // given
        List<Integer> rankResults = new ArrayList<>(Arrays.asList(1,1,0,0,0));

        // when
        long totalWinningAmount = LottoHandler.getTotalWinningAmount(rankResults);

        // then
        assertThat(totalWinningAmount).isEqualTo(55000L);
    }

    @Test
    @DisplayName("3등 1개, 2등 2개, 1등 1개일 때 결과값은 2,061,500,000원이어야 한다.")
    void getTotalWinningAmount_2() {
        // given
        List<Integer> rankResults = new ArrayList<>(Arrays.asList(0,0,1,2,1));

        // when
        long totalWinningAmount = LottoHandler.getTotalWinningAmount(rankResults);

        // then
        assertThat(totalWinningAmount).isEqualTo(2061500000L);
    }
}