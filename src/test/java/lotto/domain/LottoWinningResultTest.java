package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoWinningResultTest {

    @DisplayName("LottoWinningResult 생성 테스트")
    @Test
    void makeLottoWinningResult() {
        // Given
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        List<LottoRow> lottoRows = new ArrayList<>();
        LottoRow lottoRow = new LottoRow();
        lottoRows.add(lottoRow);

        // When
        LottoWinningResult lottoWinningResult = new LottoWinningResult(winningNumbers, lottoRows);

        // Then
        Assertions.assertTrue(lottoWinningResult.getLottoWinningCount(LottoWinningRating.FOURTH) <= 1);
    }
}