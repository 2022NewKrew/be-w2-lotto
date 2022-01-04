package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoWinningResultTest {

    @DisplayName("LottoWinningResult 생성 테스트 - FOURTH의 winningCount 개수가 1개 이하가 True")
    @Test
    void makeLottoWinningResult_WinningNumbers123456_WinningCountUnder1() {
        // Given
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto = new Lotto();
        lottoList.add(lotto);

        int bonusBallNumber = 7;

        // When
        LottoWinningResult lottoWinningResult = new LottoWinningResult(winningNumbers, bonusBallNumber, lottoList);

        // Then
        Assertions.assertTrue(lottoWinningResult.getLottoWinningCount(LottoWinningRating.FOURTH) <= 1);
    }

}
