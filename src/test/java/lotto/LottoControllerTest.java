package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.vo.LottoVO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    @Test
    void purchaseLottos() {
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService);
        List<LottoVO> lottos = lottoController.purchaseLottos(10);
        assertEquals(10, lottos.size());
    }
}