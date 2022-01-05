package lotto.domain.result;

import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.Lotto;
import lotto.domain.lotto.number.WinningNumber;
import lotto.dto.WinningResultOutput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WinningResultTest {

    @Test
    @DisplayName("당첨자 확인 테스트")
    void lottoWinningResultTest() {
        //given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(5, 12, 25, 1, 2, 3));
        BonusNumber bonusNumber = new BonusNumber(4);
        List<Lotto> lotteries = new ArrayList<>();
        lotteries.add(Lotto.createLotto(() -> Arrays.asList(5, 12, 25, 32, 35, 39)));
        lotteries.add(Lotto.createLotto(() -> Arrays.asList(5, 23, 32, 37, 38, 43)));
        int lottoPrice = 2000;

        Map<WinningRanking, Long> expected = new HashMap<>();
        expected.put(WinningRanking.FIFTH, 1L);
        expected.put(WinningRanking.UNRANKED, 1L);
        //when
        WinningResult winningResult = new WinningResult(winningNumber, bonusNumber);
        WinningResultOutput result = winningResult.winningResultRequest(Lotteries.create(lotteries), lottoPrice);
        //then
        Assertions.assertThat(result.getWinningResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("보너스 당첨자 확인 테스트")
    void bonusLottoWinningResultTest() {
        //given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(5, 12, 25, 1, 2, 3));
        BonusNumber bonusNumber = new BonusNumber(4);
        List<Lotto> lotteries = new ArrayList<>();
        lotteries.add(Lotto.createLotto(() -> Arrays.asList(5, 12, 25, 32, 35, 39)));
        lotteries.add(Lotto.createLotto(() -> Arrays.asList(5, 12, 25, 1, 2, 4)));
        lotteries.add(Lotto.createLotto(() -> Arrays.asList(5, 23, 32, 37, 38, 43)));
        int lottoPrice = 3000;

        Map<WinningRanking, Long> expected = new HashMap<>();
        expected.put(WinningRanking.FIFTH, 1L);
        expected.put(WinningRanking.SECOND, 1L);
        expected.put(WinningRanking.UNRANKED, 1L);

        //when
        WinningResult winningResult = new WinningResult(winningNumber, bonusNumber);
        WinningResultOutput result = winningResult.winningResultRequest(Lotteries.create(lotteries), lottoPrice);
        //then
        Assertions.assertThat(result.getWinningResult()).isEqualTo(expected);
    }
}
