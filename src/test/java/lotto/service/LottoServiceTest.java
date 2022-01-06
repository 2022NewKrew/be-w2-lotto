package lotto.service;

import lotto.service.domain.LottoGame;
import lotto.util.LottoConstantValue;
import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void purchaseLottoTest(){

        //given
        long budget = 10000;
        int gameCount = (int) (budget/ LottoConstantValue.LOTTO_PRICE);

        //when
        LottoGame lottoGame = lottoService.purchaseLottoGame(10000);

        //then
//        assertEqual(lottoGame.getLottoTickets().size(), 10);
    }

}