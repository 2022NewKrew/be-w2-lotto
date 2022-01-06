package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoNumberGeneratorTest {

    @DisplayName("수동 로또 번호 생성 테스트")
    @Test
    public void create() {
        LottoNumbersGenerator manualLottoNumberGenerator = new ManualLottoNumberGenerator();
        String[] strings = {"1", "2", "3", "4", "5", "6"};

        LottoNumbers lottoNumbers = manualLottoNumberGenerator.generateLottoNumbers(strings);

        assertThat(lottoNumbers.getLottoNumbers()).contains(LottoNumber.from(1));
    }
}