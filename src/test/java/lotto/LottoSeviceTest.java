package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    void purchaseLottos() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.purchaseLottos(10);
        assertEquals(10, lottos.size());
    }
}