package service;

import domain.Lotto;
import domain.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultManagerTest {

    @BeforeEach
    void setUp(){
        OwnLotto ownLottoTest = new OwnLotto(3,0);
        LottoTestGenerator lottoTestGenerator = new LottoTestGenerator();
        ownLottoTest.generate(lottoTestGenerator);

        ArrayList<Number> inputNumberList = new ArrayList<>(Arrays.asList(new Number(1),new Number(2),
                new Number(3),new Number(14),
                new Number(15),new Number(26)));
        Lotto winningLotto = new Lotto(inputNumberList);

        ResultManager = new ResultManager(ownLottoTest, winningLottoTest);
    }

    @Test
    void 수익_테스트(){
        assertEquals(ResultManager.getProfit(), 5000);
    }

    @Test
    void 수익률_테스트(){
        assertEquals(ResultManager.getProfitPercent(), 166);
    }
}