package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {

    @DisplayName("지난 주 당첨 번호 모음과 보너스 볼 생성 테스트")
    @Test
    public void create() {
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }
        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);
        LottoNumber bonusNumber = LottoNumber.from(7);

        WinningNumbers winningNumbers = WinningNumbers.from(lottoNumbers, bonusNumber);

        assertThat(winningNumbers.getWinningNumbers()).isEqualTo(lottoNumbers);
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("보너스 볼이 당첨 번호와 중복될 경우 테스트")
    @Test
    public void createDuplicatedBonusNumber() {
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }
        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);
        LottoNumber bonusNumber = LottoNumber.from(6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumbers.from(lottoNumbers, bonusNumber))
                .withMessage("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
    }
}