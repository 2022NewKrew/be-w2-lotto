package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    Lotto lotto;

    @BeforeEach
    void setUp() {
        List<LottoTicket> lottoTickets = List.of(new LottoTicket(List.of(new LottoNumber(7), new LottoNumber(11), new LottoNumber(20), new LottoNumber(28), new LottoNumber(44), new LottoNumber(45))),
                new LottoTicket(List.of(new LottoNumber(31), new LottoNumber(23), new LottoNumber(36), new LottoNumber(41), new LottoNumber(19), new LottoNumber(8))));
        lotto = new Lotto(lottoTickets);
    }

    @Test
    void 로또_당첨_결과() {
        lotto.checkLottoResult(List.of(new LottoNumber(7), new LottoNumber(11), new LottoNumber(20),
                new LottoNumber(31), new LottoNumber(23), new LottoNumber(36)));

        LottoResults lottoResults = lotto.getResult();
        assertEquals(0, lottoResults.getCountBy(LottoResult.FIRST));
        assertEquals(0, lottoResults.getCountBy(LottoResult.THIRD));
        assertEquals(0, lottoResults.getCountBy(LottoResult.FOURTH));
        assertEquals(2, lottoResults.getCountBy(LottoResult.FIFTH));
    }

    @Test
    void 로또_당첨_금액_확인() {
        lotto.checkLottoResult(List.of(new LottoNumber(7), new LottoNumber(11), new LottoNumber(20),
                new LottoNumber(31), new LottoNumber(23), new LottoNumber(36)));

        assertEquals(10_000, lotto.getEarnedMoney());
    }

}