package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoRankCalculatorTest {

    @DisplayName("당첨 결과 통계 테스트")
    @Test
    void getLottoResults() {
        LottoResultCalculator simulator = new LottoResultCalculator(List.of(1, 2, 3, 4, 5, 6), 7);
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 3, 4, 5, 44, 45)), // 4등
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new LottoTicket(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new LottoTicket(List.of(1, 2, 3, 43, 44, 45)), // 5등
                new LottoTicket(List.of(1, 3, 4, 5, 7, 8)), // 4등
                new LottoTicket(List.of(1, 2, 3, 4, 8, 9)), // 4등
                new LottoTicket(List.of(7, 8, 9, 10, 11, 12)) // 꽝
                );

        Map<LottoRank, Integer> lottoResult = simulator.getLottoResultCounts(tickets);

        assertThat(lottoResult.get(LottoRank.FIRST)).isEqualTo(2);
        assertThat(lottoResult.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.get(LottoRank.THIRD)).isEqualTo(0);
        assertThat(lottoResult.get(LottoRank.FOURTH)).isEqualTo(3);
        assertThat(lottoResult.get(LottoRank.FIFTH)).isEqualTo(1);
    }

}