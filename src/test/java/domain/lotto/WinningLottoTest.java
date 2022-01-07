package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    private final static List<Integer> LOTTO_SEQUENCE = List.of(1, 2, 3, 4, 5, 6);
    private final static int BONUS_NUMBER = 7;

    @Test
    @DisplayName("로또 번호 리스트와 보너스 번호를 통해 당첨 번호를 생성한다.")
    void createWinningLotto() {
        //when
        WinningLotto winningLotto = new WinningLotto(LOTTO_SEQUENCE, BONUS_NUMBER);

        //then
        for (Integer lottoNumber : LOTTO_SEQUENCE) {
            assertThat(winningLotto.isContainsNumber(lottoNumber)).isTrue();
        }
        assertThat(winningLotto.getBonusNumber()).isEqualTo(BONUS_NUMBER);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호는 중복될 수 없다.")
    void failToCreateWinningLottoByDuplicateBonusNumber() {
        //when
        int duplicateBonusNumber = LOTTO_SEQUENCE.get(0);

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(LOTTO_SEQUENCE, duplicateBonusNumber))
                .withMessage("[에러] 보너스 번호는 당첨 번호와 같을 수 없습니다.");
    }

}