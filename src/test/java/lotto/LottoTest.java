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
        ArrayList<Integer> lottoNumbers = lotto.getLottoNumbers();
        System.out.println(lottoNumbers);
        assertThat(lottoNumbers.size()).isEqualTo(6);
        for(var lottoNumber: lottoNumbers) {
            assertThat(lottoNumber).isGreaterThanOrEqualTo(0);
            assertThat(lottoNumber).isLessThanOrEqualTo(45);
        }
    }

    @Test
    void testGetLottoNumbers() {
    }

    @Test
    void countMatch() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,7,8,9));
        assertThat(winningLotto.countMatch(lotto2)).isEqualTo(3);
    }
}