package com.cold.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

import com.cold.models.WholeTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameLogicTest {
    
    @Test
    @DisplayName("수익률 설정 테스트")
    void setProfitRate() {
        //given
        WholeTickets wholeTickets = new WholeTickets();
        wholeTickets.initTickets(4);
        Map sampleMap = new HashMap<String, Integer>() {
            {
                put("THREE", 0);
                put("FOUR", 1);
                put("FIVE", 0);
                put("BONUS", 1);
                put("SIX", 0);
            }
        };

        //when
        wholeTickets.wholeResult = sampleMap;
        wholeTickets.setProfitRate();

        //then
        assertThat(wholeTickets.getProfitRate()).isEqualTo(751150);


    }
}