package lotto;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void getLottoNumbers() {
        Lotto lotto = new Lotto();
        ArrayList<LottoBall> lottoNumbers = lotto.getLottoNumbers();
        Set<LottoBall> set = new HashSet<>(lottoNumbers);
        assertThat(set.size()).isEqualTo(6);
    }

    @Test
    void testGetLottoNumbers() {
    }

    @Test
    void countMatch() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B6), LottoBall.B45);
        Lotto lotto2 = new Lotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B7,LottoBall.B8,LottoBall.B9));
        assertThat(winningLotto.getRank(lotto2)).isEqualTo(Rank.FIFTH);
    }
}