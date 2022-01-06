package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoRankCalculatorTest {

    private LottoResultCalculator calculator;
    private List<LottoTicket> tickets;

    @BeforeEach
    private void setup() {
        LottoNumbers winningLottoNumbers = LottoNumbers.createByNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusLottoNumber = new LottoNumber(7);
        WinningCondition winningCondition = new WinningCondition(winningLottoNumbers, bonusLottoNumber);
        calculator = new LottoResultCalculator(winningCondition);
        tickets = List.of(
                new LottoTicket(LottoNumbers.createByNumbers(List.of(1, 3, 4, 5, 44, 45))), // 4등
                new LottoTicket(LottoNumbers.createByNumbers(List.of(1, 2, 3, 4, 5, 6))), // 1등
                new LottoTicket(LottoNumbers.createByNumbers(List.of(1, 2, 3, 4, 5, 6))), // 1등
                new LottoTicket(LottoNumbers.createByNumbers(List.of(1, 2, 3, 4, 5, 7))), // 2등
                new LottoTicket(LottoNumbers.createByNumbers(List.of(1, 2, 3, 43, 44, 45))), // 5등
                new LottoTicket(LottoNumbers.createByNumbers(List.of(1, 3, 4, 5, 7, 8))), // 4등
                new LottoTicket(LottoNumbers.createByNumbers(List.of(1, 2, 3, 4, 8, 9))), // 4등
                new LottoTicket(LottoNumbers.createByNumbers(List.of(7, 8, 9, 10, 11, 12))) // 꽝
        );
    }

    @DisplayName("당첨 결과 통계 테스트")
    @Test
    void getLottoResultCounts() {
        Map<LottoRank, Integer> resultCounts = calculator.getLottoResultCounts(tickets);

        assertThat(resultCounts.get(LottoRank.FIRST)).isEqualTo(2);
        assertThat(resultCounts.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(resultCounts.get(LottoRank.THIRD)).isEqualTo(0);
        assertThat(resultCounts.get(LottoRank.FOURTH)).isEqualTo(3);
        assertThat(resultCounts.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(resultCounts.get(LottoRank.NONE)).isEqualTo(1);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateEarningRate() {
        long sum = calculator.calculateEarningRate(tickets);

        Map<LottoRank, Integer> resultCounts = calculator.getLottoResultCounts(tickets);
        long earning = 0L;
        int totalCount = 0;
        for (LottoRank rank : resultCounts.keySet()) {
            totalCount += resultCounts.get(rank);
            earning += (long) resultCounts.get(rank) * rank.getWinningMoney();
        }
        int original = totalCount * LottoTicket.PRICE;
        long expectedEarningRate = (earning - original) * 100 / original;
        assertThat(sum).isEqualTo(expectedEarningRate);
    }

}