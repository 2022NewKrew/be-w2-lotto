package lotto.domain.winning;

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
        Map<Integer, Integer> winningResult = new HashMap<>();
        winningResult.put(3, 1);
        winningResult.put(4, 0);
        winningResult.put(5, 0);
        winningResult.put(6, 0);
        int lottoPrice = 14000;
        int expected = 35;

        //when
        int result = EarningRate.calculate(winningResult, lottoPrice);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
