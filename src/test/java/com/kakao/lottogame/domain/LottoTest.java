package com.kakao.lottogame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("로또 번호가 6개가 아니면 로또를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 7})
    void constructor_NotSix_exception(int size) {
        List<LottoNumber> lottoNumbers = new Random().ints(1, 46).distinct().limit(size).sorted()
            .mapToObj(LottoNumber::of).collect(Collectors.toList());
        assertThatThrownBy(() -> Lotto.of(lottoNumbers)).hasMessage("로또 번호는 총 6개입니다.");
    }
}