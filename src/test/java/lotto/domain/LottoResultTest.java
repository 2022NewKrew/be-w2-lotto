package lotto.domain;

import lotto.domain.userinput.WinningLottoDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    static List<Lotto> lottoList;
    static int purchaseMoney = 100000;

    @BeforeAll
    static void init() {
        lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 8, 10)));
    }

    @Test
    void 결과는_5등_3개() {
        //given
        WinningLottoDto winningLottoDto = new WinningLottoDto(new Lotto(List.of(1, 2, 3, 11, 12, 13)), 10);
        int expectedFifthCount = 3;
        int expectedProfit = Rank.FIFTH.getWinningMoney() * expectedFifthCount;

        //when
        LottoResult lottoResult = new LottoResult(lottoList, winningLottoDto);

        //then
        assertEquals(expectedFifthCount, lottoResult.getCountOfRank(Rank.FIFTH));
        assertEquals(expectedProfitRate(expectedProfit), lottoResult.profitRate(purchaseMoney));
    }

    @Test
    void 결과는_2등_3등_5등_1개씩() {
        //given
        WinningLottoDto winningLottoDto = new WinningLottoDto(new Lotto(List.of(1, 2, 3, 7, 8, 10)), 9);
        int expectedCount = 1;
        int expectedProfit = Rank.SECOND.getWinningMoney() + Rank.THIRD.getWinningMoney() + Rank.FIFTH.getWinningMoney();

        //when
        LottoResult lottoResult = new LottoResult(lottoList, winningLottoDto);

        //then
        assertEquals(expectedCount, lottoResult.getCountOfRank(Rank.SECOND));
        assertEquals(expectedCount, lottoResult.getCountOfRank(Rank.THIRD));
        assertEquals(expectedCount, lottoResult.getCountOfRank(Rank.FIFTH));
        assertEquals(expectedProfitRate(expectedProfit), lottoResult.profitRate(purchaseMoney));
    }

    long expectedProfitRate(int profit){
        return (profit-purchaseMoney)*100L/purchaseMoney;
    }
}