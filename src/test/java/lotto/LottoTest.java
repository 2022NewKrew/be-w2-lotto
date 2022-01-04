package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void getLottoNumbers() {
        Lotto lotto = new Lotto();
        ArrayList<LottoBall> lottoNumbers = lotto.getLottoNumbers();
        System.out.println(lottoNumbers);
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void testGetLottoNumbers() {
    }

    @Test
    void countMatch() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B4,LottoBall.B5,LottoBall.B6));
        Lotto lotto2 = new Lotto(Arrays.asList(LottoBall.B1,LottoBall.B2,LottoBall.B3,LottoBall.B7,LottoBall.B8,LottoBall.B9));
        assertThat(winningLotto.countMatch(lotto2)).isEqualTo(3);
    }
}