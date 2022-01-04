package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @DisplayName("중복 숫자를 포함하지 않는 6개의 로또 번호로 로또 티켓 생성 테스트")
    @Test
    public void create() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 1; i < 7; i++) {
            lottoNumbers.add(LottoNumber.from(i));
        }

        LottoNumbers lottoTicket = LottoNumbers.from(lottoNumbers);

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @DisplayName("중복 숫자를 포함한 6개의 로또 번호로 로또 티켓 생성 테스트")
    @Test
    public void duplicate() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(LottoNumber.from(1));
        for (int i = 1; i < 6; i++) {
            lottoNumbers.add(LottoNumber.from(i));
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.from(lottoNumbers))
                .withMessage("로또 번호는 중복없는 6개의 숫자여야 합니다.");
    }

    @DisplayName("6개 미만의 로또 번호 로또 티켓 생성 테스트")
    @Test
    public void lessLength() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 1; i < 6; i++) {
            lottoNumbers.add(LottoNumber.from(i));
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.from(lottoNumbers))
                .withMessage("로또 번호는 중복없는 6개의 숫자여야 합니다.");
    }

    @DisplayName("6개 초과의 로또 번호로 로또 티켓 생성 테스트")
    @Test
    public void overLength() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 1; i < 8; i++) {
            lottoNumbers.add(LottoNumber.from(i));
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.from(lottoNumbers))
                .withMessage("로또 번호는 중복없는 6개의 숫자여야 합니다.");
    }
}
