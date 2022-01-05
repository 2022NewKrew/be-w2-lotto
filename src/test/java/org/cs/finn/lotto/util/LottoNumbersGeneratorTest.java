package org.cs.finn.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumbersGeneratorTest {
    private final SecureRandom sRand = new SecureRandom();

    @Test
    @DisplayName("Lotto 번호 생성 시 LottoNumbers 객체 유효성 검사에서 예외가 발생하지 않아야 한다")
    public void testNoException() {
        assertThatNoException().isThrownBy(() -> LottoNumbersGenerator.getLottoNumbers(sRand));
    }
}
