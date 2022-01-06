package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void 번호_5개를_맞추고_보너스_볼을_맞추면_2등(){
        //given
        LottoMatchDto lottoMatchDto = new LottoMatchDto(5, true);

        //when
        Rank rank = Rank.valueOf(lottoMatchDto);

        //then
        assertEquals(Rank.SECOND, rank);
    }

    @Test
    void 번호_5개를_맞추고_보너스_볼을_맞추지_못하면_3등(){
        //given
        LottoMatchDto lottoMatchDto = new LottoMatchDto(5, false);

        //when
        Rank rank = Rank.valueOf(lottoMatchDto);

        //then
        assertEquals(Rank.THIRD, rank);
    }

    @Test
    void 번호_3개를_맞추면_5등(){
        //given
        LottoMatchDto lottoMatchDto = new LottoMatchDto(3, true);

        //when
        Rank rank = Rank.valueOf(lottoMatchDto);

        //then
        assertEquals(Rank.FIFTH, rank);
    }
}