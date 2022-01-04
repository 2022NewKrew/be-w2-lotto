package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoSeviceTest {

    @Test
    void purchaseLottos() {
        LottoSevice lottoSevice = new LottoSevice();
        List<Lotto> lottos = lottoSevice.purchaseLottos(10);
        assertEquals(10, lottos.size());
    }
}