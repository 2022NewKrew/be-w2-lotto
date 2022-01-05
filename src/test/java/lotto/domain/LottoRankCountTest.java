package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.game.LottoRankCount;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningLotto;
import org.junit.jupiter.api.Test;

class LottoRankCountTest {

    private static final LottoNumber NUM_1 = LottoNumber.from(1);
    private static final LottoNumber NUM_2 = LottoNumber.from(2);
    private static final LottoNumber NUM_3 = LottoNumber.from(3);
    private static final LottoNumber NUM_4 = LottoNumber.from(4);
    private static final LottoNumber NUM_5 = LottoNumber.from(5);
    private static final LottoNumber NUM_6 = LottoNumber.from(6);
    private static final LottoNumber NUM_7 = LottoNumber.from(7);
    private static final LottoNumber NUM_8 = LottoNumber.from(8);
    private static final LottoNumber NUM_9 = LottoNumber.from(9);

    private static final List<LottoNumber> WINNING_LOTTO_NUMBERS =
        List.of(NUM_1, NUM_2, NUM_3, NUM_4, NUM_5, NUM_6);

    private static final List<LottoNumber> FIRST_RANK_NUMBERS =
        List.of(NUM_1, NUM_2, NUM_3, NUM_4, NUM_5, NUM_6);
    private static final List<LottoNumber> SECOND_RANK_NUMBERS =
        List.of(NUM_1, NUM_2, NUM_3, NUM_4, NUM_5, NUM_7);
    private static final List<LottoNumber> THIRD_RANK_NUMBERS =
        List.of(NUM_1, NUM_2, NUM_3, NUM_4, NUM_5, NUM_8);
    private static final List<LottoNumber> FOURTH_RANK_NUMBERS =
        List.of(NUM_1, NUM_2, NUM_3, NUM_4, NUM_7, NUM_8);
    private static final List<LottoNumber> FIFTH_RANK_NUMBERS =
        List.of(NUM_1, NUM_2, NUM_3, NUM_7, NUM_8, NUM_9);

    @Test
    void getLottoRankCount() {
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(WINNING_LOTTO_NUMBERS),
            NUM_7);

        Lotto first = Lotto.from(FIRST_RANK_NUMBERS);
        Lotto second = Lotto.from(SECOND_RANK_NUMBERS);
        Lotto third = Lotto.from(THIRD_RANK_NUMBERS);
        Lotto fourth = Lotto.from(FOURTH_RANK_NUMBERS);
        Lotto fifth = Lotto.from(FIFTH_RANK_NUMBERS);

        LottoTickets lottoTickets = LottoTickets.from(List.of(first, first,
            second, second,
            third, third,
            fourth, fourth,
            fifth, fifth));

        LottoRankCount lottoRankCount = LottoRankCount.of(winningLotto, lottoTickets);

        lottoRankCount.getLottoRankCount()
            .forEach(((lottoRank, count) -> assertThat(count).isEqualTo(2L)));
    }
}
