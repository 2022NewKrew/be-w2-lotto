package lotto.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private static final LottoService lottoService = new LottoService();

    @Test
    void purchaseLottoTest(){
        lottoService.purchaseLottoGame(10000);
    }

}