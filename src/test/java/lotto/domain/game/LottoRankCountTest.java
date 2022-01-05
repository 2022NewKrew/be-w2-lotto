package lotto.domain.game;

import static lotto.domain.helper.LottoNumberHelper.convertNumbersToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankCountTest {

    private static final List<Integer> WINNING_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> FIRST_RANK_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> SECOND_RANK_NUMBERS = List.of(1, 2, 3, 4, 5, 7);
    private static final List<Integer> THIRD_RANK_NUMBERS = List.of(1, 2, 3, 4, 5, 8);
    private static final List<Integer> FOURTH_RANK_NUMBERS = List.of(1, 2, 3, 4, 7, 8);
    private static final List<Integer> FIFTH_RANK_NUMBERS = List.of(1, 2, 3, 7, 8, 9);

    private static final int BONUS_NUMBER = 7;

    @DisplayName("로또 당첨 등수 카운트 테스트")
    @Test
    void getLottoRankCount() {
        // Given
        WinningLotto winningLotto = WinningLotto.of(
            Lotto.from(convertNumbersToLottoNumbers(WINNING_LOTTO_NUMBERS)),
            LottoNumber.from(BONUS_NUMBER));

        Lotto first = Lotto.from(convertNumbersToLottoNumbers(FIRST_RANK_NUMBERS));
        Lotto second = Lotto.from(convertNumbersToLottoNumbers(SECOND_RANK_NUMBERS));
        Lotto third = Lotto.from(convertNumbersToLottoNumbers(THIRD_RANK_NUMBERS));
        Lotto fourth = Lotto.from(convertNumbersToLottoNumbers(FOURTH_RANK_NUMBERS));
        Lotto fifth = Lotto.from(convertNumbersToLottoNumbers(FIFTH_RANK_NUMBERS));

        LottoTickets lottoTickets = LottoTickets.from(List.of(
            first, first,
            second, second,
            third, third,
            fourth, fourth,
            fifth, fifth));

        // When
        LottoRankCount lottoRankCount = LottoRankCount.of(winningLotto, lottoTickets);

        // Then
        lottoRankCount.getLottoRankCount()
            .forEach(((lottoRank, count) -> assertThat(count).isEqualTo(2L)));
    }

    @Test
    void calculateTotalPrizeMoney() {
        // Given
        WinningLotto winningLotto = WinningLotto.of(
            Lotto.from(convertNumbersToLottoNumbers(WINNING_LOTTO_NUMBERS)),
            LottoNumber.from(BONUS_NUMBER));

        Lotto first = Lotto.from(convertNumbersToLottoNumbers(FIRST_RANK_NUMBERS));
        Lotto second = Lotto.from(convertNumbersToLottoNumbers(SECOND_RANK_NUMBERS));
        Lotto third = Lotto.from(convertNumbersToLottoNumbers(THIRD_RANK_NUMBERS));
        Lotto fourth = Lotto.from(convertNumbersToLottoNumbers(FOURTH_RANK_NUMBERS));
        Lotto fifth = Lotto.from(convertNumbersToLottoNumbers(FIFTH_RANK_NUMBERS));

        LottoTickets lottoTickets = LottoTickets.from(List.of(
            first,
            second,
            third,
            fourth,
            fifth));

        LottoRankCount lottoRankCount = LottoRankCount.of(winningLotto, lottoTickets);

        // When
        long totalPrize = lottoRankCount.calculateTotalPrizeMoney();

        // Then
        assertThat(totalPrize)
            .isEqualTo((long) Stream.of(LottoRank.values())
                .map(LottoRank::getPrizeMoney)
                .reduce(0, Integer::sum));
    }
}
