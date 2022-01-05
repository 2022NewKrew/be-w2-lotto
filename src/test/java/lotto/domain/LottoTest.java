package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 6:55
 */
class LottoTest {
    static WinningLotto winningLotto;

    @BeforeAll
    static void 로또_번호_세팅() {
        List<Integer> lastWeekWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusBall = 10;
        winningLotto = new WinningLotto(lastWeekWinningNumbers, bonusBall);
    }

    @Test
    void 로또_번호_맞춰보기() {
        // given
        List<Integer> lotto1 = Arrays.asList(1, 2, 7, 8, 9, 10);
        List<Integer> lotto2 = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto givenLotto = new Lotto(lotto1);

        // then
        assertThat(givenLotto.matchLottoWithLastWeek(lotto2)).isEqualTo(2);
    }

    @Test
    void 로또_등수_4등() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 8, 9);
        Lotto lotto = new Lotto(numbers);

        // when
        Rank rank = winningLotto.matchLotto(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);

    }

    @Test
    void 로또_등수_2등() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 10);
        Lotto lotto = new Lotto(numbers);

        // when
        Rank rank = winningLotto.matchLotto(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 로또_등수_없음() {
        // given
        List<Integer> numbers = Arrays.asList(11, 12, 13, 14, 15, 16);
        Lotto lotto = new Lotto(numbers);

        // when
        Rank rank = winningLotto.matchLotto(lotto);

        // then
        assertThat(rank).isNull();
    }
}