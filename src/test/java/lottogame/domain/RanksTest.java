package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class RanksTest {

    @Test
    @DisplayName("상금 합계 구하기")
    void checkSumPrizeMoney() {
        Ranks ranks = new Ranks(Arrays.asList(Rank.FIRST, Rank.FIFTH));
        int prizeMoney = Rank.FIRST.getPrizeMoney() + Rank.FIFTH.getPrizeMoney();

        assertThat(ranks.sumPrizeMoney()).isEqualTo(prizeMoney);
    }
}