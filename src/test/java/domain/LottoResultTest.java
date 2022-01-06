package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    int LOTTO_PRICE = 1000;
    LottoResult result;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,7)));
        Lotto lotto3 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,8)));
        Lotto lotto4 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,7,8)));
        Lotto lotto5 = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,7,8,9)));
        Lotto lotto6 = new Lotto(new ArrayList<>(Arrays.asList(1,2,7,8,9,10)));
        Lotto lotto7 = new Lotto(new ArrayList<>(Arrays.asList(1,7,8,9,10,11)));
        Lotto lotto8 = new Lotto(new ArrayList<>(Arrays.asList(7,8,9,10,11,12)));
        ArrayList<Lotto> lottoList = new ArrayList<>(
                Arrays.asList(lotto1,lotto2,lotto3,lotto4,lotto5,lotto6,lotto7,lotto8));
        ArrayList<Integer> winningNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        result = new LottoResult(lottoList, winningLotto);
    }

    @Test
    void testYieldPercent() {
        int purchaseMoney = 8 * LOTTO_PRICE;
        float yield = 100.0f * (2031555000 - purchaseMoney) / purchaseMoney;
        assertEquals(result.getYieldByPercent(LOTTO_PRICE), yield);
    }

    @Test
    void getTotalWinningMoney() {
        assertEquals(result.getTotalWinningMoney(), 2031555000);
    }
}
