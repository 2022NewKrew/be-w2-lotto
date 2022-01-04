package domain;

import domain.lottonumber.BasicNumber;
import domain.lottonumber.BonusNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    Lotto lotto;

    @BeforeEach
    void setUp() {
        List<LottoTicket> lottoTickets = List.of(new LottoTicket(List.of(new BasicNumber(7), new BasicNumber(11), new BasicNumber(20),
                        new BasicNumber(28), new BasicNumber(44), new BasicNumber(45))),
                new LottoTicket(List.of(new BasicNumber(31), new BasicNumber(23), new BasicNumber(36),
                        new BasicNumber(41), new BasicNumber(19), new BasicNumber(8))));
        lotto = new Lotto(lottoTickets);
    }

    @Test
    void 로또_당첨_결과() {
        lotto.checkLottoResult(List.of(new BasicNumber(7), new BasicNumber(11), new BasicNumber(20),
                new BasicNumber(31), new BasicNumber(23), new BasicNumber(36), new BonusNumber(28)));

        LottoResults lottoResults = lotto.getResult();
        assertEquals(0, lottoResults.getCountBy(LottoResult.FIRST));
        assertEquals(0, lottoResults.getCountBy(LottoResult.THIRD));
        assertEquals(0, lottoResults.getCountBy(LottoResult.FOURTH));
        assertEquals(2, lottoResults.getCountBy(LottoResult.FIFTH));
    }

    @Test
    void 로또_당첨_금액_확인() {
        lotto.checkLottoResult(List.of(new BasicNumber(7), new BasicNumber(11), new BasicNumber(20),
                new BasicNumber(31), new BasicNumber(23), new BasicNumber(36), new BonusNumber(28)));
        assertEquals(10_000, lotto.getEarnedMoney());
    }

}