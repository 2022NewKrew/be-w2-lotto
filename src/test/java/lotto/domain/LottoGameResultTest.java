package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGameResultTest {

    private static final List<Integer> WINNING_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final int BONUS_NUMBER = 7;

    private static final List<Integer> FIRST_RANK_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> SECOND_RANK_NUMBERS = List.of(1, 2, 3, 4, 5, 7);
    private static final List<Integer> THIRD_RANK_NUMBERS = List.of(1, 2, 3, 4, 5, 8);
    private static final List<Integer> FOURTH_RANK_NUMBERS = List.of(1, 2, 3, 4, 7, 8);
    private static final List<Integer> FIFTH_RANK_NUMBERS = List.of(1, 2, 3, 7, 8, 9);

    @Test
    void getLottoRankCount() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(WINNING_LOTTO_NUMBERS),
            BONUS_NUMBER);

        Lotto first = new Lotto(FIRST_RANK_NUMBERS);
        Lotto second = new Lotto(SECOND_RANK_NUMBERS);
        Lotto third = new Lotto(THIRD_RANK_NUMBERS);
        Lotto fourth = new Lotto(FOURTH_RANK_NUMBERS);
        Lotto fifth = new Lotto(FIFTH_RANK_NUMBERS);

        List<Lotto> lottoList = List.of(first, first,
            second, second,
            third, third,
            fourth, fourth,
            fifth, fifth);

        LottoGameResult lottoGameResult = new LottoGameResult(winningLotto,
            lottoList,
            5000);

        lottoGameResult.getLottoRankCount()
            .forEach(((lottoRank, count) -> assertThat(count).isEqualTo(2L)));
    }
}
