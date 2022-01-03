package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.kakao.lottogame.service.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    private final RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();

    @DisplayName("제한된 범위 내의 중복하지 않는 랜덤 숫자 6개를 생성한다.")
    @Test
    void generate_Random_SixNumbers() {
        Lotto lotto = lottoGenerator.generate();
        assertThat(lotto.getNumbers().stream().distinct()).hasSize(Lotto.SIZE);
    }
}