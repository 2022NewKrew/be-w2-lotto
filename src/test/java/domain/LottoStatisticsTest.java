package domain;

import java.util.EnumMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    @Test
    @DisplayName("[성공] LottoStatistics 객체를 생성한다")
    void LottoStatistics() {
        EnumMap<Prize, Integer> winningLottoCount = new EnumMap<>(Prize.class);
        winningLottoCount.put(Prize.MISS, 1);
        winningLottoCount.put(Prize.FIFTH, 1);
        winningLottoCount.put(Prize.THIRD, 1);
        winningLottoCount.put(Prize.FOURTH, 1);
        winningLottoCount.put(Prize.SECOND, 1);
        winningLottoCount.put(Prize.FIRST, 1);

        new LottoStatistics(winningLottoCount);
    }

    @Test
    @DisplayName("[실패] 생성자에 null이 들어올 때 IllegalArgumentException 던져야 한다")
    void LottoStatistics_Failed_By_Null() {
        EnumMap<Prize, Integer> winningLottoCount = null;

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new LottoStatistics(winningLottoCount));
    }

    @Test
    @DisplayName("[성공] 수익률을 올바르게 계산한다")
    void rateOfReturn() {
        long purchaseAmount = 14000;
        EnumMap<Prize, Integer> winningLottoCount = new EnumMap<>(Prize.class);
        winningLottoCount.put(Prize.MISS, 13);
        winningLottoCount.put(Prize.FIFTH, 1);
        winningLottoCount.put(Prize.THIRD, 0);
        winningLottoCount.put(Prize.FOURTH, 0);
        winningLottoCount.put(Prize.SECOND, 0);
        winningLottoCount.put(Prize.FIRST, 0);
        double rateOfReturn_Answer = -64.28571428571429;
        LottoStatistics lottoStatistics = new LottoStatistics(winningLottoCount);

        double rateOfReturn = lottoStatistics.rateOfReturn(purchaseAmount);

        Assertions.assertEquals(rateOfReturn, rateOfReturn_Answer);
    }
}