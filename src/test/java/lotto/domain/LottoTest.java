package lotto.domain;

import lotto.domain.userinput.WinningLottoDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    static WinningLottoDto winningLottoDto;

    @BeforeAll
    static void init(){
        Lotto winningTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusBall = 7;
        winningLottoDto = new WinningLottoDto(winningTicket, bonusBall);
    }

    @Test
    void 당첨_번호_4개를_맞추고_보너스_볼은_맞추지_못함(){
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));

        //when
        LottoMatchDto lottoMatchDto = lotto.countMatchedNumber(winningLottoDto.getWinningTicket(), winningLottoDto.getBonusBall());

        //then
        assertEquals(4, lottoMatchDto.getCount());
        assertFalse(lottoMatchDto.isBonusBall());
    }

    @Test
    void 당첨_번호_5개를_맞추고_보너스_볼도_맞춤(){
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //when
        LottoMatchDto lottoMatchDto = lotto.countMatchedNumber(winningLottoDto.getWinningTicket(), winningLottoDto.getBonusBall());

        //then
        assertEquals(5, lottoMatchDto.getCount());
        assertTrue(lottoMatchDto.isBonusBall());
    }
}