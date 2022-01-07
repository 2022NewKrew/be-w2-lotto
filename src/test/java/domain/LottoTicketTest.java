package domain;

import domain.lottonumber.BasicNumber;
import domain.lottonumber.BonusNumber;
import domain.dto.LottoMatchResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(List.of(new BasicNumber(1), new BasicNumber(2), new BasicNumber(3),
                new BasicNumber(4), new BasicNumber(5), new BasicNumber(6)));
    }

    @Test
    void 당첨번호_매칭하여_결과dto를_반환한다() {
        LottoMatchResultDto lottoMatchResultDto = lottoTicket.getNumberOfMatchedNumber(List.of(new BasicNumber(1), new BasicNumber(2), new BasicNumber(3),
                new BasicNumber(4), new BasicNumber(5), new BasicNumber(11), new BonusNumber(6)));

        assertEquals(5, lottoMatchResultDto.getNumberOfMatchedBasicNumber());
        assertTrue(lottoMatchResultDto.isMatchedBonusNumber());
    }

}