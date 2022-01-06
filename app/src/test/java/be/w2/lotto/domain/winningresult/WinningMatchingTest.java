package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottonumber.LottoNumber;
import be.w2.lotto.domain.lottoticket.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningMatchingTest {

    @Test
    void countMatchingResult_매칭_결과를_카운트해_반환한다() {
        // given
        int lottoPurchaseAmount = 2;
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7)
        );
        LottoTickets lottoTickets = LottoTickets.valueOf(lottoPurchaseAmount, lottoNumbers);
        List<Integer> winningLottoNumbers = List.of(2, 3, 4, 5, 6, 7);
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf(winningLottoNumbers);
        BonusNumber bonusNumber = BonusNumber.valueOf(8, winningLottoTicket);
        List<Integer> expected = List.of(0, 0, 1, 0, 1);

        // when
        List<Integer> actual = Rewards.stream().map(reward ->
                WinningMatching.countMatchingResult(reward, lottoTickets, winningLottoTicket, bonusNumber)
        ).collect(Collectors.toList());

        // then
        assertThat(actual).isEqualTo(expected);
    }
}