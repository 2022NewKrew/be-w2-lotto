package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoSetting.LOTTO_AUTO;
import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("올바른_당첨번호_일치_개수를_반환한다.")
    void calculateMatchCount() {
        List<Integer>listA = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer>listB = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        LottoNumber lottoA = new LottoNumber(listA, LOTTO_AUTO);
        LottoNumber lottoB = new LottoNumber(listB, LOTTO_AUTO);

        assertThat(lottoA.calculateMatchCount(lottoB)).isEqualTo(6);
    }
}