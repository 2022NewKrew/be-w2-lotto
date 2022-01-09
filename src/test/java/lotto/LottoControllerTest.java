package lotto;

import lotto.controller.LottoController;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    @Test
    void purchaseLottos() {
        LottoController lottoController = new LottoController();
        List<LottoDto> lottos = lottoController.purchaseLottos(10);
        assertEquals(10, lottos.size());
    }
}