package com.cold.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameLogicTest {

    @Test
    @DisplayName("수익률 설정 테스트")
    void setProfitRate() {
        //given
        WholeTickets wholeTickets = new WholeTickets(5);
        Map sampleMap = new HashMap<Integer, Integer>() {
            {
                put(3, 0);
                put(4, 1);
                put(5, 0);
                put(6, 0);
                put(7, 1);
            }
        };

        wholeTickets.wholeResult = sampleMap;

        //when
        double profitRate = GameLogic.calculateProfitRate(wholeTickets);
        wholeTickets.setProfitRate(profitRate);

        //then
        assertThat(wholeTickets.getProfitRate()).isEqualTo((double) 600900);
    }
}