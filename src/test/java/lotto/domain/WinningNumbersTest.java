package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    @DisplayName("지난 주 당첨 번호 모음 생성 테스트")
    @Test
    public void create() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }
        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);

        WinningNumbers winningNumbers = WinningNumbers.from(lottoNumbers);

        assertThat(winningNumbers.getWinningNumbers()).isEqualTo(lottoNumbers);
    }
}