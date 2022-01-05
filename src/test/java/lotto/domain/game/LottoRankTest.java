package lotto.domain.game;

import static lotto.domain.game.LottoRank.FIFTH;
import static lotto.domain.game.LottoRank.FIRST;
import static lotto.domain.game.LottoRank.FOURTH;
import static lotto.domain.game.LottoRank.SECOND;
import static lotto.domain.game.LottoRank.THIRD;
import static lotto.domain.helper.LottoNumberHelper.convertNumbersToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    private static final List<Integer> WINNING_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> FIRST_RANK_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> SECOND_RANK_NUMBERS = List.of(1, 2, 3, 4, 5, 7);
    private static final List<Integer> THIRD_RANK_NUMBERS = List.of(1, 2, 3, 4, 5, 8);
    private static final List<Integer> FOURTH_RANK_NUMBERS = List.of(1, 2, 3, 4, 7, 8);
    private static final List<Integer> FIFTH_RANK_NUMBERS = List.of(1, 2, 3, 7, 8, 9);

    private static final int BONUS_NUMBER = 7;

    @Test
    @DisplayName("로또 등수 테스트")
    void valueOf() {
        WinningLotto winningLotto = WinningLotto.of(
            Lotto.from(convertNumbersToLottoNumbers(WINNING_LOTTO_NUMBERS)),
            LottoNumber.from(BONUS_NUMBER));

        Lotto first = Lotto.from(convertNumbersToLottoNumbers(FIRST_RANK_NUMBERS));
        Lotto second = Lotto.from(convertNumbersToLottoNumbers(SECOND_RANK_NUMBERS));
        Lotto third = Lotto.from(convertNumbersToLottoNumbers(THIRD_RANK_NUMBERS));
        Lotto fourth = Lotto.from(convertNumbersToLottoNumbers(FOURTH_RANK_NUMBERS));
        Lotto fifth = Lotto.from(convertNumbersToLottoNumbers(FIFTH_RANK_NUMBERS));

        assertThat(LottoRank.valueOf(winningLotto, first))
            .isEqualTo(FIRST);
        assertThat(LottoRank.valueOf(winningLotto, second))
            .isEqualTo(SECOND);
        assertThat(LottoRank.valueOf(winningLotto, third))
            .isEqualTo(THIRD);
        assertThat(LottoRank.valueOf(winningLotto, fourth))
            .isEqualTo(FOURTH);
        assertThat(LottoRank.valueOf(winningLotto, fifth))
            .isEqualTo(FIFTH);
    }
}
