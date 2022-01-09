package domain;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    static Set<Integer> winningNumbers;

    @BeforeAll
    static void setUp() {
        createWinningNumbers();
    }

    @Test
    @DisplayName("[성공] 수익률을 올바르게 계산한다")
    void rateOfReturn() {
        long purchaseAmount = 14000;
        double rateOfReturn_Answer = -64.28571428571429;
        int bonusNumber = 7;
        LastWeekLottoResult lottoResult = new LastWeekLottoResult(winningNumbers, bonusNumber);
        List<Lotto> lottoList = List.of(createLottoNumbers(1, 2, 3, 10, 11, 12));
        LottoStatistics lottoStatistics = new LottoStatistics(lottoResult.winningLottoCount(lottoList));

        double rateOfReturn = lottoStatistics.rateOfReturn(purchaseAmount, lottoList);

        Assertions.assertEquals(rateOfReturn, rateOfReturn_Answer);
    }

    Lotto createLottoNumbers(int n1, int n2, int n3, int n4, int n5, int n6) {
        Set<Integer> lottoNumbers = Set.of(n1, n2, n3, n4, n5, n6);

        return new Lotto(lottoNumbers);
    }

    static void createWinningNumbers() {
        winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
    }
}