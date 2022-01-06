package lotto.domain.result;

import lotto.domain.lotto.result.EarningRate;
import lotto.domain.lotto.result.WinningRanking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class EarningRateTest {

    @Test
    @DisplayName("수익률 계산이 일치하는지 확인하는 테스트")
    void earningRateCorrectTest() {
        //given
        Map<WinningRanking, Long> winningResult = new HashMap<>();
        winningResult.put(WinningRanking.FIRST, 0L);
        winningResult.put(WinningRanking.SECOND, 0L);
        winningResult.put(WinningRanking.THIRD, 0L);
        winningResult.put(WinningRanking.FOURTH, 0L);
        winningResult.put(WinningRanking.FIFTH, 1L);
        int lottoPrice = 14000;
        int expected = 35;

        //when
        int result = EarningRate.calculate(winningResult, lottoPrice);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
