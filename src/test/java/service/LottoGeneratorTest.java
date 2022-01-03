package service;

import domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    void 정해진_수만큼_로또티켓을_생성한다() {
        Lotto lotto = lottoGenerator.makeLotto(5);
        assertEquals(5, lotto.getNumberOfLottoTicket());
    }

}