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
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.createLotto(() -> Arrays.asList(1,2,3,7,8,9)));
        lottos.add(Lotto.createLotto(() -> Arrays.asList(10,11,12,13,14,15)));
        lottos.add(Lotto.createLotto(() -> Arrays.asList(16,17,18,19,20,21)));
        int lottoPrice = 14000;

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
