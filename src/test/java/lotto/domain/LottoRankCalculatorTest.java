package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoRankCalculatorTest {

    @DisplayName("당첨 번호를 주었을 때, 로또 티켓들에 대한 결과를 테스트 한다.")
    @Test
    void getLottoResults() {
        LottoResultCalculator simulator = new LottoResultCalculator(List.of(1, 2, 3, 4, 5, 6));
        List<LottoTicket> tickets = List.of(
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new LottoTicket(List.of(1, 2, 3, 4, 5, 7)),
                new LottoTicket(List.of(1, 2, 3, 43, 44, 45))
        );

        Map<LottoRank, Integer> lottoResult = simulator.getLottoResultCounts(tickets);

        assertThat(lottoResult.get(LottoRank.FIRST)).isEqualTo(2);
        assertThat(lottoResult.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.get(LottoRank.THIRD)).isEqualTo(null);
        assertThat(lottoResult.get(LottoRank.FOURTH)).isEqualTo(1);
    }

}