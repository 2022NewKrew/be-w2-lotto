package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void valueOf() {
        // given
        int noneMatch = 0;
        int matchedFourth = 4;
        int matchedFifth = 5;
        boolean bonus = true;

        // when
        LottoRank lottoRank0 = LottoRank.valueOf(noneMatch, false);
        LottoRank lottoRank4 = LottoRank.valueOf(matchedFourth, false);
        LottoRank lottoRank5 = LottoRank.valueOf(matchedFifth, false);
        LottoRank lottoRankBonus5 = LottoRank.valueOf(matchedFifth, bonus);

        // then
        Assertions.assertThat(lottoRank0).isEqualTo(LottoRank.MISS);
        Assertions.assertThat(lottoRank4).isEqualTo(LottoRank.FOUR);
        Assertions.assertThat(lottoRank5).isEqualTo(LottoRank.THREE);
        Assertions.assertThat(lottoRankBonus5).isEqualTo(LottoRank.TWO);
    }
}