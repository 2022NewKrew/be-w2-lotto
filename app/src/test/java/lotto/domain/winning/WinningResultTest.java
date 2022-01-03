package lotto.domain.winning;

import lotto.domain.lotto.Lotto;
import lotto.dto.WinningResultResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WinningResultTest {

    @Test
    void lottoWinningResultTest() {
        //given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(5, 12, 25, 1, 2, 3));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.createLotto(() -> Arrays.asList(5, 12, 25, 32, 35, 39)));
        lottos.add(Lotto.createLotto(() -> Arrays.asList(5, 23, 32, 37, 38, 43)));
        int lottoPrice = 2000;

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(3, 1);
        expected.put(4, 0);
        expected.put(5, 0);
        expected.put(6, 0);
        //when
        WinningResult winningResult = new WinningResult(winningNumber);
        WinningResultResponse result = winningResult.winningResultRequest(lottos, lottoPrice);
        //then
        Assertions.assertThat(result.getWinningResult()).isEqualTo(expected);
    }
}
