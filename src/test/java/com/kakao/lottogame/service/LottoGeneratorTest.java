package com.kakao.lottogame.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.kakao.lottogame.domain.Lotto;
import com.kakao.lottogame.domain.LottoNumber;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private final long SEED = 1L;
    private final LottoGenerator lottoGenerator = new LottoGenerator(SEED);

    @DisplayName("제한된 범위 내의 중복하지 않는 랜덤 번호 6개를 생성한다.")
    @Test
    void generate_Random_SixNumbers() {
        Lotto lotto = lottoGenerator.generateAuto();
        Lotto expected = Lotto.of(
            List.of(LottoNumber.of(5), LottoNumber.of(16), LottoNumber.of(29), LottoNumber.of(34),
                LottoNumber.of(38), LottoNumber.of(45)));
        assertThat(lotto).isEqualTo(expected);
    }
}