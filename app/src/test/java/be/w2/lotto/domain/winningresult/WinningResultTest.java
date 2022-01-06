package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {

    @Test
    void valueOf_객체_생성에_성공하고_WinningResult_객체를_반환한다() {
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
        Class<WinningResult> expected = WinningResult.class;

        Rewards.stream().forEach(reward -> {
            // when
            WinningResult actual = WinningResult.valueOf(reward, lottoTickets, winningLottoTicket, bonusNumber);

            // then
            assertThat(actual).isInstanceOf(expected);
        });
    }

    @Test
    void getMatchedNumber_객체의_matchedNumber에_해당하는_값을_반환한다() {
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
        List<Integer> expected = List.of(3, 4, 5, 5, 6);

        // when
        List<Integer> actual = Rewards.stream().map(reward -> {
            WinningResult winningResult = WinningResult.valueOf(reward, lottoTickets, winningLottoTicket, bonusNumber);
            return winningResult.getMatchedNumber();
        }).collect(Collectors.toList());

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getReward_객체의_reward에_해당하는_값을_반환한다() {
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
        List<Integer> expected = List.of(5000, 50000, 1500000, 30000000, 2000000000);

        // when
        List<Integer> actual = Rewards.stream().map(reward -> {
            WinningResult winningResult = WinningResult.valueOf(reward, lottoTickets, winningLottoTicket, bonusNumber);
            return winningResult.getReward();
        }).collect(Collectors.toList());

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getCount_객체의_count에_해당하는_값을_반환한다() {
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
        List<Integer> actual = Rewards.stream().map(reward -> {
            WinningResult winningResult = WinningResult.valueOf(reward, lottoTickets, winningLottoTicket, bonusNumber);
            return winningResult.getCount();
        }).collect(Collectors.toList());

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void isBonusRound_객체의_isBonus에_해당하는_값을_반환한다() {
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
        List<Boolean> expected = List.of(false, false, false, true, false);

        // when
        List<Boolean> actual = Rewards.stream().map(reward -> {
            WinningResult winningResult = WinningResult.valueOf(reward, lottoTickets, winningLottoTicket, bonusNumber);
            return winningResult.isBonusRound();
        }).collect(Collectors.toList());

        // then
        assertThat(actual).isEqualTo(expected);
    }
}