package be.w2.lotto.domain.numbergenerator;

import be.w2.lotto.domain.lottoticket.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static be.w2.lotto.domain.lottonumber.LottoNumber.LOTTO_NUMBER_LOWERBOUND;
import static be.w2.lotto.domain.lottonumber.LottoNumber.LOTTO_NUMBER_UPPERBOUND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoNumberGeneratorTest {

    @Test
    void generateLottoTickets_입력받은_Integer_리스트로_lottoTicket_객체_리스트를_생성하고_반환한다() {
        // given
        ManualLottoNumberGenerator manualLottoNumberGenerator = new ManualLottoNumberGenerator();
        int expectedNumberCount = 2;
        List<List<Integer>> expectedNumbers = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6));

        Class<LottoTicket> expected = LottoTicket.class;

        // when
        List<LottoTicket> actuals = manualLottoNumberGenerator.generateLottoTickets(expectedNumberCount, expectedNumbers);

        // then
        assertThat(actuals.size()).isEqualTo(expectedNumberCount);
        actuals.forEach(actual -> assertThat(actual).isInstanceOf(expected));
        List<List<Integer>> actualNumbers = actuals.stream()
                .map(LottoTicket::getLottoNumbers)
                .collect(Collectors.toList());
        assertThat(actualNumbers).isEqualTo(expectedNumbers);
    }
}
