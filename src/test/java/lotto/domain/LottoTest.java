package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 6:55
 */
class LottoTest {

    @Test
    void matchLottoWithLastWeek() {
        // given
        List<Integer> lotto1 = Arrays.asList(1, 2, 7, 8, 9, 10);
        List<Integer> lotto2 = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto givenLotto = new Lotto(lotto1);

        // then
        assertThat(givenLotto.matchLottoWithLastWeek(lotto2)).isEqualTo(2);
    }

}