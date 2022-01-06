package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumberGeneratorTest {

    @DisplayName("랜덤으로 로또 번호 6개 생성 테스트")
    @Test
    void generateLottoNumbers() {
        LottoNumbersGenerator lottoNumbersGenerator = new RandomLottoNumberGenerator();

        LottoNumbers lottoNumbers = lottoNumbersGenerator.generateLottoNumbers(null);

        assertThat(lottoNumbers.getLottoNumbers()).hasSize(6);
    }
}